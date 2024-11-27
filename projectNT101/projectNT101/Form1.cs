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
            if (string.IsNullOrEmpty(input))
            {
                MessageBox.Show("Please enter a message to encode.");
                return;
            }
            string keyword = "KEYWORD"; // Replace with user input if needed
            string encoded = PlayfairCipher.Encode(input, keyword);
            lblResult.Text = "Result: " + encoded;
        }

        private void btnDecode_Click(object sender, EventArgs e)
        {
            string input = txtInput.Text;
            if (string.IsNullOrEmpty(input))
            {
                MessageBox.Show("Please enter a message to decode.");
                return;
            }

            string keyword = "KEYWORD"; // Replace with user input if needed
            string decoded = PlayfairCipher.Decode(input, keyword);
            lblResult.Text = "Result: " + decoded;
        }

        public static class PlayfairCipher
        {
            public static string Encode(string message, string keyword)
            {
                // Implement Playfair encode logic
                return "EncodedMessage"; // Placeholder
            }

            public static string Decode(string message, string keyword)
            {
                // Implement Playfair decode logic
                return "DecodedMessage"; // Placeholder
            }
        }
    }
}
