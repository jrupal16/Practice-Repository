<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="TextMessageWebApplication.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <table border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td style="width: 80px">
            Enter mobile number:
        </td>
        <td>
            <asp:TextBox ID="txtTo" runat="server"></asp:TextBox>
        </td>
        <td>
            <asp:DropDownList runat="server" ID="yourDDL">
                <asp:ListItem Text="T-mobile" Value="tmobile" />
                <asp:ListItem Text="AT&T" Value="att" />
                <asp:ListItem Text="Verizon" Value="verizon" />
                <asp:ListItem Text="Lyca Mobile" Value="lyca" />
            </asp:DropDownList>
        </td>
    </tr>
    <tr>
        <td>
            &nbsp;
        </td>
    </tr>
    <tr>
        <td>
            Subject:
        </td>
        <td>
            <asp:TextBox ID="txtSubject" runat="server"></asp:TextBox>
        </td>
    </tr>
    <tr>
        <td>
            &nbsp;
        </td>
    </tr>
    <tr>
        <td valign = "top">
            Body:
        </td>
        <td>
            <asp:TextBox ID="txtBody" runat="server" TextMode = "MultiLine" Height = "150" Width = "200"></asp:TextBox>
        </td>
    </tr>
    <tr>
        <td>
            &nbsp;
        </td>
    </tr>
    
   
    <tr>
        <td>
            &nbsp;
        </td>
    </tr>
        <tr>
        <td>
            File Attachment:
        </td>
        <td>
            <asp:FileUpload ID="fuAttachment" runat="server" />
        </td>
    </tr>
    <tr>
        <td>
            &nbsp;
        </td>
    </tr>
    <tr>
        <td>
        </td>
        <td>
            <asp:Button Text="Send" OnClick="SendEmail" runat="server" />
        </td>
    </tr>
     <tr>
            <td>
                <b>Result</b>
            </td>
            <td class="auto-style1">
                <asp:Label ID="lblResult" runat="server"></asp:Label>
            </td>
        </tr>
</table>
    </div>
    </form>
</body>
</html>
