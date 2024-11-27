namespace projectNT101
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            btnEncode = new Button();
            btnDecode = new Button();
            txtInput = new TextBox();
            lblResult = new Label();
            txtKey = new TextBox();
            SuspendLayout();
            // 
            // btnEncode
            // 
            btnEncode.Location = new Point(100, 110);
            btnEncode.Margin = new Padding(4, 5, 4, 5);
            btnEncode.Name = "btnEncode";
            btnEncode.Size = new Size(100, 35);
            btnEncode.TabIndex = 0;
            btnEncode.Text = "Encode";
            btnEncode.UseVisualStyleBackColor = true;
            btnEncode.Click += btnEncode_Click;
            // 
            // btnDecode
            // 
            btnDecode.Location = new Point(200, 110);
            btnDecode.Margin = new Padding(4, 5, 4, 5);
            btnDecode.Name = "btnDecode";
            btnDecode.Size = new Size(100, 35);
            btnDecode.TabIndex = 1;
            btnDecode.Text = "Decode";
            btnDecode.UseVisualStyleBackColor = true;
            btnDecode.Click += btnDecode_Click;
            // 
            // txtInput
            // 
            txtInput.Location = new Point(100, 80);
            txtInput.Margin = new Padding(4, 5, 4, 5);
            txtInput.Name = "txtInput";
            txtInput.Size = new Size(200, 23);
            txtInput.TabIndex = 2;
            // 
            // lblResult
            // 
            lblResult.AutoSize = true;
            lblResult.Location = new Point(20, 140);
            lblResult.Margin = new Padding(4, 0, 4, 0);
            lblResult.Name = "lblResult";
            lblResult.Size = new Size(50, 15);
            lblResult.TabIndex = 3;
            lblResult.Text = "Result";
            // 
            // txtKey
            // 
            txtKey.Location = new Point(100, 30);
            txtKey.Name = "txtKey";
            txtKey.Size = new Size(200, 23);
            txtKey.TabIndex = 4;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(699, 348);
            Controls.Add(txtKey);
            Controls.Add(lblResult);
            Controls.Add(txtInput);
            Controls.Add(btnDecode);
            Controls.Add(btnEncode);
            Margin = new Padding(4, 5, 4, 5);
            Name = "Form1";
            Text = "PlayFair Cipher";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button btnEncode;
        private Button btnDecode;
        private TextBox txtInput;
        private Label lblResult;
        private TextBox txtKey;
    }
}
