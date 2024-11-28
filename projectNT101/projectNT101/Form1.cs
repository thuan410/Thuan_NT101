using System.Text;

namespace projectNT101
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        // Button Encode
        private void btnEncode_Click(object sender, EventArgs e)
        {
            string input = txtInput.Text;
            string key = txtKey.Text;
            if (string.IsNullOrEmpty(key) || string.IsNullOrEmpty(input))
            {
                MessageBox.Show("Key và Text không được để trống!", "Lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            try
            {
                // Xóa dữ liệu cũ của DataGridView
                dataGridViewSteps.Rows.Clear();

                // Chuẩn hóa input
                string processedInput = PrepareInput(input);
                string table = GenerateCipherTable2(key); // Tạo bảng chữ cái
                string encodedMessage = "";

                for (int i = 0; i < processedInput.Length; i += 2)
                {
                    char a = processedInput[i];
                    char b = processedInput[i + 1];

                    // Tìm vị trí của cặp ký tự
                    (int rowA, int colA) = FindPosition(a, table);
                    (int rowB, int colB) = FindPosition(b, table);

                    string stepResult;
                    if (rowA == rowB) // Cùng hàng
                    {
                        stepResult = $"{table[rowA * 5 + (colA + 1) % 5]}{table[rowB * 5 + (colB + 1) % 5]}";
                    }
                    else if (colA == colB) // Cùng cột
                    {
                        stepResult = $"{table[((rowA + 1) % 5) * 5 + colA]}{table[((rowB + 1) % 5) * 5 + colB]}";
                    }
                    else // Khác hàng, khác cột
                    {
                        stepResult = $"{table[rowA * 5 + colB]}{table[rowB * 5 + colA]}";
                    }

                    // Thêm từng bước vào DataGridView
                    dataGridViewSteps.Rows.Add(
                        $"{a}{b}",                     // Cặp ký tự
                        $"({rowA},{colA}), ({rowB},{colB})", // Vị trí ban đầu
                        stepResult                    // Kết quả
                    );

                    //Hiển thị kết quả mã hóa vào TextBox
                    //for (int j = 0; j < dataGridViewSteps.Rows.Count; j++)
                    //{
                    //    dataGridViewSteps.Rows[j].Cells[0].Value = (j + 1).ToString();
                    //}

                    encodedMessage += stepResult;
                }

                // Hiển thị kết quả mã hóa vào TextBox
                txtResult.Text = encodedMessage;
            }

            catch (Exception ex)
            {
                MessageBox.Show($"Đã xảy ra lỗi: {ex.Message}", "Lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }



        }

        //Button Decode
        private void btnDecode_Click(object sender, EventArgs e)
        {
            string input = txtInput.Text;
            string key = txtKey.Text;
            if (string.IsNullOrEmpty(key) || string.IsNullOrEmpty(input))
            {
                MessageBox.Show("Key và Text không được để trống!", "Lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }


            try
            {
                // Xóa dữ liệu cũ của DataGridView
                dataGridViewSteps.Rows.Clear();

                // Chuẩn hóa input
                string processedInput = PrepareInput(input);
                string table = GenerateCipherTable2(key); // Tạo bảng chữ cái
                string decodedMessage = "";

                for (int i = 0; i < processedInput.Length; i += 2)
                {
                    char a = processedInput[i];
                    char b = processedInput[i + 1];

                    // Tìm vị trí của cặp ký tự
                    (int rowA, int colA) = FindPosition(a, table);
                    (int rowB, int colB) = FindPosition(b, table);

                    string stepResult;
                    if (rowA == rowB) // Cùng hàng
                    {
                        colA = (colA + 4) % 5; // Di chuyển ngược lại
                        colB = (colB + 4) % 5;
                        stepResult = $"{table[rowA * 5 + colA]}{table[rowB * 5 + colB]}";
                    }
                    else if (colA == colB) // Cùng cột
                    {
                        rowA = (rowA + 4) % 5; // Di chuyển ngược lại
                        rowB = (rowB + 4) % 5;
                        stepResult = $"{table[rowA * 5 + colA]}{table[rowB * 5 + colB]}";
                    }
                    else // Khác hàng, khác cột
                    {
                        stepResult = $"{table[rowA * 5 + colB]}{table[rowB * 5 + colA]}";
                    }

                    // Thêm từng bước vào DataGridView
                    dataGridViewSteps.Rows.Add(
                        $"{a}{b}",                     // Cặp ký tự
                        $"({rowA},{colA}), ({rowB},{colB})", // Vị trí ban đầu
                        stepResult                    // Kết quả
                    );

                    decodedMessage += stepResult;
                }

                // Hiển thị kết quả giải mã vào TextBox
                txtResult.Text = decodedMessage;
            }

            catch (Exception ex)
            {
                MessageBox.Show($"Đã xảy ra lỗi: {ex.Message}", "Lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        public static class PlayfairCipher
        {
            public static string Encode(string message, string keyword)
            {
                string[,] table = GenerateCipherTable(keyword);
                message = PrepareMessage(message);

                return ProcessMessage(message, table, isEncoding: true);

            }

            public static string Decode(string message, string keyword)
            {
                string[,] table = GenerateCipherTable(keyword);
                message = PrepareMessage(message, addX: false); // Không thêm 'X' khi giải mã

                return ProcessMessage(message, table, isEncoding: false);


            }
        }

        private static string[,] GenerateCipherTable(string keyword)
        {
            string alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
            keyword = keyword.ToUpper().Replace("J", "I");
            HashSet<char> used = new HashSet<char>();

            string combined = keyword + alphabet;
            string unique = "";
            foreach (char c in combined)
            {
                if (!used.Contains(c))
                {
                    used.Add(c);
                    unique += c;
                }
            }

            string[,] table = new string[5, 5];

            // Code để điền vào bảng cipher
            int index = 0;
            for (int row = 0; row < 5; row++)
            {
                for (int col = 0; col < 5; col++)
                {
                    if (index < unique.Length)
                    {
                        table[row, col] = unique[index].ToString();
                        index++;
                    }
                }
            }

            return table; // Đảm bảo luôn trả về bảng cipher
        }

        private static string PrepareMessage(string message, bool addX = true)
        {
            message = message.ToUpper().Replace("J", "I").Replace(" ", "");
            string prepared = "";

            for (int i = 0; i < message.Length; i += 2)
            {
                char first = message[i];
                char second = (i + 1 < message.Length) ? message[i + 1] : 'X';

                if (first == second && addX)
                {
                    prepared += first + "X";
                    i--; // Quay lại để xử lý cặp tiếp theo
                }
                else
                {
                    prepared += first.ToString() + second.ToString();
                }
            }

            if (prepared.Length % 2 != 0 && addX)
                prepared += "X";

            return prepared;
        }

        private static string ProcessMessage(string message, string[,] table, bool isEncoding)
        {
            string result = "";
            for (int i = 0; i < message.Length; i += 2)
            {
                char first = message[i];
                char second = message[i + 1];

                Point pos1 = FindPosition(table, first);
                Point pos2 = FindPosition(table, second);

                if (pos1.X == pos2.X) // Cùng hàng
                {
                    result += table[pos1.X, (pos1.Y + (isEncoding ? 1 : 4)) % 5];
                    result += table[pos2.X, (pos2.Y + (isEncoding ? 1 : 4)) % 5];
                }
                else if (pos1.Y == pos2.Y) // Cùng cột
                {
                    result += table[(pos1.X + (isEncoding ? 1 : 4)) % 5, pos1.Y];
                    result += table[(pos2.X + (isEncoding ? 1 : 4)) % 5, pos2.Y];
                }
                else // Hình chữ nhật
                {
                    result += table[pos1.X, pos2.Y];
                    result += table[pos2.X, pos1.Y];
                }
            }

            return result;
        }

        private static Point FindPosition(string[,] table, char c)
        {
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    if (table[i, j][0] == c)
                        return new Point(i, j);
                }
            }

            throw new ArgumentException($"Character {c} not found in cipher table.");
        }

        private void btnGenerateTable_Click(object sender, EventArgs e)
        {
            string keyword = txtKey.Text;
            GenerateCipherTable1(keyword);
        }

        private void GenerateCipherTable1(string keyword)
        {
            // Loại bỏ các ký tự trùng lặp trong keyword và thay thế 'J' bằng 'I'
            string alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; // Lược bỏ 'J'
            keyword = keyword.ToUpper().Replace("J", "I");
            string keyString = "";

            // Thêm từ khóa vào bảng chữ cái, loại bỏ các ký tự đã tồn tại trong bảng chữ cái
            foreach (char c in keyword)
            {
                if (!keyString.Contains(c))
                {
                    keyString += c;
                }
            }

            // Thêm các chữ cái còn thiếu vào bảng
            foreach (char c in alphabet)
            {
                if (!keyString.Contains(c))
                {
                    keyString += c;
                }
            }

            // Hiển thị bảng chữ cái Playfair trong TextBox
            txtCipherTable.Clear();
            int counter = 0;
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    txtCipherTable.Text += keyString[counter] + " ";
                    counter++;
                }
                txtCipherTable.Text += Environment.NewLine;
            }
        }

        private string GenerateCipherTable2(string keyword)
        {
            string alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; // Loại J
            keyword = keyword.ToUpper().Replace("J", "I");

            string keyString = new string(keyword.Distinct().ToArray()); // Loại bỏ ký tự trùng lặp
            string remaining = new string(alphabet.Except(keyString).ToArray()); // Ký tự còn lại

            return keyString + remaining; // Kết hợp từ khóa và các ký tự còn lại
        }

        private (int, int) FindPosition(char c, string table)
        {
            int index = table.IndexOf(c);
            return (index / 5, index % 5); // Trả về hàng và cột
        }

        private string PrepareInput(string input)
        {
            input = input.ToUpper().Replace("J", "I"); // Chuyển sang chữ hoa và thay thế J bằng I
            input = new string(input.Where(char.IsLetter).ToArray()); // Loại bỏ ký tự không phải chữ

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < input.Length; i += 2)
            {
                char a = input[i];
                char b = (i + 1 < input.Length) ? input[i + 1] : 'X'; // Nếu lẻ, thêm X vào cuối

                if (a == b) // Nếu trùng ký tự, chèn X
                {
                    b = 'X';
                    i--;
                }

                result.Append(a).Append(b);
            }

            return result.ToString();
        }

        private void btn_exit_Click(object sender, EventArgs e)
        {
            Form2 form2 = new Form2();
            form2.Show();
            
        }
    }
}
