using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Net;
using System.Net.Mail;
using System.Text;



namespace TextMessageWebApplication
{
    /// <summary>
    /// Summary description for TextMessageWebService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class TextMessageWebService : System.Web.Services.WebService
    {

        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }
        [WebMethod]
        public string SendTextMessage(string toNumber, string carrier, string subject, string body, string attachment)
        {
            string txtStatus = "success";
            try
            {
                SmtpClient client = new SmtpClient();
                client.Port = 587;
                client.Host = "smtp.gmail.com";
                client.EnableSsl = true;
                client.Timeout = 100000;
                client.DeliveryMethod = SmtpDeliveryMethod.Network;
                client.UseDefaultCredentials = false;
                if (attachment == null || attachment.Length == 0)
                    attachment = null;
                if (carrier.Equals("tmobile") || carrier.Equals("lyca"))
                {
                    toNumber = toNumber + "@tmomail.net";
                }
                else if (carrier.Equals("att"))
                {
                    if (attachment != null)
                    {
                        toNumber = toNumber + "@mms.att.net";
                    }
                    else
                        toNumber = toNumber + "@txt.att.net";
                }
                else if (carrier.Equals("verizon"))
                {
                    toNumber = toNumber + "@vtext.com";
                }

                client.Credentials = new System.Net.NetworkCredential("cs540project@gmail.com", "strongtiger");

                MailMessage mm = new MailMessage("cs540project@gmail.com", toNumber, subject, body);
                mm.BodyEncoding = UTF8Encoding.UTF8;
                mm.DeliveryNotificationOptions = DeliveryNotificationOptions.OnFailure;
                if (attachment != null)
                {
                    mm.Attachments.Add(new Attachment(attachment));
                }
                client.Send(mm);

                if (attachment != null)
                {
                    mm.Attachments.Dispose();
                    System.IO.File.Delete(attachment);
                }

            }
            catch (Exception ex)
            { 

                txtStatus = "failure" + ex;
            }
            

            return txtStatus;
        }
    }
}
