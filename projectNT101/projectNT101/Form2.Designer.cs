namespace projectNT101
{
    partial class Form2
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            btnPlayFairCipher1 = new Button();
            btnPlayFairCipher2 = new Button();
            SuspendLayout();
            // 
            // btnPlayFairCipher1
            // 
            btnPlayFairCipher1.Location = new Point(322, 133);
            btnPlayFairCipher1.Name = "btnPlayFairCipher1";
            btnPlayFairCipher1.Size = new Size(165, 43);
            btnPlayFairCipher1.TabIndex = 0;
            btnPlayFairCipher1.Text = "Word";
            btnPlayFairCipher1.UseVisualStyleBackColor = true;
            btnPlayFairCipher1.Click += btnPlayFairCipher1_Click;
            // 
            // btnPlayFairCipher2
            // 
            btnPlayFairCipher2.Location = new Point(322, 193);
            btnPlayFairCipher2.Name = "btnPlayFairCipher2";
            btnPlayFairCipher2.Size = new Size(165, 45);
            btnPlayFairCipher2.TabIndex = 1;
            btnPlayFairCipher2.Text = "Word and Number";
            btnPlayFairCipher2.UseVisualStyleBackColor = true;
            btnPlayFairCipher2.Click += btnPlayFairCipher2_Click;
            // 
            // Form2
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btnPlayFairCipher2);
            Controls.Add(btnPlayFairCipher1);
            Name = "Form2";
            Text = "Menu";
            Load += Form2_Load;
            ResumeLayout(false);
        }

        #endregion

        private Button btnPlayFairCipher1;
        private Button btnPlayFairCipher2;
    }
}