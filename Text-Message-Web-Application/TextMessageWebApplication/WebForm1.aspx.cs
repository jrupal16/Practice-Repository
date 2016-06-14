using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;
using System.Net;
using System.Net.Mail;
using System.Text;


namespace TextMessageWebApplication
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void SendEmail(object sender, EventArgs e)
        {
            TextMessageService.TextMessageWebServiceSoapClient client = new TextMessageService.TextMessageWebServiceSoapClient();

            string attachment;
            if (fuAttachment.HasFile)
                attachment = SaveFile(fuAttachment.PostedFile);
            else
                attachment = null;
            string result = client.SendTextMessage(Convert.ToString(txtTo.Text), Convert.ToString(yourDDL.Text), Convert.ToString(txtSubject.Text),
               Convert.ToString(txtBody.Text), attachment);
            lblResult.Text = result;
         
        }

        string SaveFile(HttpPostedFile file)
        {
            string savePath = "c:\\temp\\uploads\\";
            string fileName = fuAttachment.FileName;
            string pathToCheck = savePath + fileName;
            string tempfileName = "";

            if (System.IO.File.Exists(pathToCheck))
            {
                int counter = 2;
                while (System.IO.File.Exists(pathToCheck))
                {
                    // if a file with this name already exists, 
                    // prefix the filename with a number.
                    tempfileName = counter.ToString() + fileName;
                    pathToCheck = savePath + tempfileName;
                    counter++;
                }
                fileName = tempfileName;
                savePath += fileName;
                fuAttachment.SaveAs(savePath);

               
            }
            savePath += fileName;
            fuAttachment.SaveAs(savePath);
            return savePath;
        }

    }
}