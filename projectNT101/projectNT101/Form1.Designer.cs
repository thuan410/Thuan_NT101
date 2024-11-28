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
            label1 = new Label();
            label2 = new Label();
            txtResult = new TextBox();
            txtCipherTable = new TextBox();
            btnGenerateTable = new Button();
            dataGridViewSteps = new DataGridView();
            Column1 = new DataGridViewTextBoxColumn();
            Column2 = new DataGridViewTextBoxColumn();
            Column3 = new DataGridViewTextBoxColumn();
            btn_exit = new Button();
            ((System.ComponentModel.ISupportInitialize)dataGridViewSteps).BeginInit();
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
            txtInput.Size = new Size(200, 27);
            txtInput.TabIndex = 2;
            // 
            // lblResult
            // 
            lblResult.AutoSize = true;
            lblResult.Location = new Point(17, 170);
            lblResult.Margin = new Padding(4, 0, 4, 0);
            lblResult.Name = "lblResult";
            lblResult.Size = new Size(49, 20);
            lblResult.TabIndex = 3;
            lblResult.Text = "Result";
            // 
            // txtKey
            // 
            txtKey.Location = new Point(100, 30);
            txtKey.Name = "txtKey";
            txtKey.Size = new Size(200, 27);
            txtKey.TabIndex = 4;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(21, 29);
            label1.Name = "label1";
            label1.Size = new Size(33, 20);
            label1.TabIndex = 5;
            label1.Text = "Key";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(23, 80);
            label2.Name = "label2";
            label2.Size = new Size(43, 20);
            label2.TabIndex = 6;
            label2.Text = "Input";
            // 
            // txtResult
            // 
            txtResult.Location = new Point(102, 167);
            txtResult.Name = "txtResult";
            txtResult.Size = new Size(198, 27);
            txtResult.TabIndex = 7;
            // 
            // txtCipherTable
            // 
            txtCipherTable.Location = new Point(364, 30);
            txtCipherTable.Multiline = true;
            txtCipherTable.Name = "txtCipherTable";
            txtCipherTable.Size = new Size(131, 116);
            txtCipherTable.TabIndex = 8;
            // 
            // btnGenerateTable
            // 
            btnGenerateTable.Location = new Point(364, 167);
            btnGenerateTable.Name = "btnGenerateTable";
            btnGenerateTable.Size = new Size(131, 29);
            btnGenerateTable.TabIndex = 9;
            btnGenerateTable.Text = "GenerateTable";
            btnGenerateTable.UseVisualStyleBackColor = true;
            btnGenerateTable.Click += btnGenerateTable_Click;
            // 
            // dataGridViewSteps
            // 
            dataGridViewSteps.AllowUserToAddRows = false;
            dataGridViewSteps.AllowUserToDeleteRows = false;
            dataGridViewSteps.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewSteps.Columns.AddRange(new DataGridViewColumn[] { Column1, Column2, Column3 });
            dataGridViewSteps.Location = new Point(21, 223);
            dataGridViewSteps.Name = "dataGridViewSteps";
            dataGridViewSteps.ReadOnly = true;
            dataGridViewSteps.RowHeadersVisible = false;
            dataGridViewSteps.RowHeadersWidth = 51;
            dataGridViewSteps.Size = new Size(378, 188);
            dataGridViewSteps.TabIndex = 10;
            // 
            // Column1
            // 
            Column1.HeaderText = "Cặp kí tự";
            Column1.MinimumWidth = 6;
            Column1.Name = "Column1";
            Column1.ReadOnly = true;
            Column1.Width = 125;
            // 
            // Column2
            // 
            Column2.HeaderText = "Vị trí ban đầu";
            Column2.MinimumWidth = 6;
            Column2.Name = "Column2";
            Column2.ReadOnly = true;
            Column2.Width = 125;
            // 
            // Column3
            // 
            Column3.HeaderText = "Kết quả";
            Column3.MinimumWidth = 6;
            Column3.Name = "Column3";
            Column3.ReadOnly = true;
            Column3.Width = 125;
            // 
            // btn_exit
            // 
            btn_exit.Location = new Point(439, 420);
            btn_exit.Name = "btn_exit";
            btn_exit.Size = new Size(94, 29);
            btn_exit.TabIndex = 11;
            btn_exit.Text = "Exit";
            btn_exit.UseVisualStyleBackColor = true;
            btn_exit.Click += btn_exit_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(545, 472);
            Controls.Add(btn_exit);
            Controls.Add(dataGridViewSteps);
            Controls.Add(btnGenerateTable);
            Controls.Add(txtCipherTable);
            Controls.Add(txtResult);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(txtKey);
            Controls.Add(lblResult);
            Controls.Add(txtInput);
            Controls.Add(btnDecode);
            Controls.Add(btnEncode);
            Margin = new Padding(4, 5, 4, 5);
            Name = "Form1";
            Text = "PlayFair Cipher1";
            ((System.ComponentModel.ISupportInitialize)dataGridViewSteps).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button btnEncode;
        private Button btnDecode;
        private TextBox txtInput;
        private Label lblResult;
        private TextBox txtKey;
        private Label label1;
        private Label label2;
        private TextBox txtResult;
        private TextBox txtCipherTable;
        private Button btnGenerateTable;
        private DataGridView dataGridViewSteps;
        private DataGridViewTextBoxColumn Column1;
        private DataGridViewTextBoxColumn Column2;
        private DataGridViewTextBoxColumn Column3;
        private Button btn_exit;
    }
}
