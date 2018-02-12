using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MyClassCollection;
namespace Florenz_Ramos_BSCS3B_Assignment
{
    public partial class Form1 : Form
    {
        MySQLDBUtilities dbutil = new MySQLDBUtilities();
        HelperMethods hm=new HelperMethods();
        public Panel panel;
        public Button button;
        public PictureBox picturebox;
        public static int panelX=10;
        public static int panelY=10;
        public static int btnX = 40;
        public static int btnY = 145;
        public static int pbX = 40;
        public static int pbY = 10;
        public static int pbW = 140;
        public static int pbH = 130;
        public static int panelWidth = 210;
        public static int panelHeight = 198;
        public static int btnWidth = 140;
        public static int btnHeight = 40;
        public void GeneratePanel(int panelLocX,int panelLocY,int w,int h)
        {
                panel = new System.Windows.Forms.Panel();
                panel.Name = "Panels";
                panel.Location = new System.Drawing.Point(panelLocX, panelLocY);
                panel.Size = new System.Drawing.Size(w,h);
                panel.BackColor = Color.White;
                Controls.Add(panel);
                panel.Controls.Add(button);
                panel.Controls.Add(picturebox);
        }
        public void GenerateButton(int btnX,int btnY,int btnW,int btnH)
        {
            button = new System.Windows.Forms.Button();
            button.Location = new System.Drawing.Point(btnX,btnY);
            button.Name = "button1";
            button.Size = new System.Drawing.Size(btnW,btnH);
            button.Text = "button1";
            button.Click += new System.EventHandler(Click_Me);
            button.UseVisualStyleBackColor = true;
            button.BackColor = Color.Black;
            button.ForeColor = Color.White;
            Controls.Add(button);
        }
        public void GeneratePictureBox(int pbX,int pbY,int pbW,int pbH)
        {
            string query = "SELECT *FROM tblcontestant;";
            DataTable dt = dbutil.SelectTable(query);
            foreach (DataRow r in dt.Rows)
            {
                try
                {
                    string picPath = r["Photopath"].ToString();
                    //picPath.Replace("\\", "\\\\");
                    picturebox = new System.Windows.Forms.PictureBox();
                    picturebox.Location = new System.Drawing.Point(pbX, pbY);
                    picturebox.Name = "PictureBoxzcz";
                    picturebox.Size = new System.Drawing.Size(pbW, pbH);
                    picturebox.BackColor = Color.Black;
                    picturebox.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
                    picturebox.Image = hm.GetCopyImage(picPath);
                    Controls.Add(picturebox);
                }
                catch(Exception e){
                    MessageBox.Show(e.Message);
                }
            }
        }

        public void Click_Me(object sender, EventArgs e)
        {
            Form2 f2 = new Form2();
            f2.ShowDialog();
        }
        public Form1()
        {
            InitializeComponent();
            dbutil.OpenConnection();
            DataTable dt = dbutil.SelectTable("SELECT COUNT(ContestantID) FROM tblcontestant;");
            foreach(DataRow r in dt.Rows)
            {
                for (int i = 1; i <=Convert.ToInt32(r[0].ToString()); i++)
                {
                    GeneratePictureBox(pbX, pbY, pbW, pbH);
                    GenerateButton(btnX, btnY, btnWidth, btnHeight);
                    GeneratePanel(panelX, panelY, panelWidth, panelHeight);
                    panelX += 220;
                    if (i % 2 == 0)
                    {
                        panelX = 12;
                        panelY += 210;
                    }

                }
            }


        }
        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
