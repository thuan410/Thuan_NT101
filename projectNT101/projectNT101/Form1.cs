namespace projectNT101
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnEncode_Click(object sender, EventArgs e)
        {
            string input = txtInput.Text;
            string key = txtKey.Text;
            if (string.IsNullOrEmpty(key) || string.IsNullOrEmpty(input))
            {
                MessageBox.Show("Key và Text không được để trống!", "Lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            string encoded = PlayfairCipher.Encode(input, key);
            lblResult.Text = $"Kết quả mã hóa: {encoded}";
        }

        private void btnDecode_Click(object sender, EventArgs e)
        {
            string input = txtInput.Text;
            string key = txtKey.Text;
            if (string.IsNullOrEmpty(key) || string.IsNullOrEmpty(input))
            {
                MessageBox.Show("Key và Text không được để trống!", "Lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            string decoded = PlayfairCipher.Decode(input, key);
            lblResult.Text = "Result: " + decoded;
        }

        public static class PlayfairCipher
        {
            public static string Encode(string message, string keyword)
            {
                return $"Mã hóa '{message}' với key '{keyword}'";
            }

            public static string Decode(string message, string keyword)
            {
                return $"Giải mã '{message}' với key '{keyword}'";

            }
        }
    }
}
