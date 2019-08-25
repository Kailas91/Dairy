<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="style.css" type="text/css" rel="stylesheet"/>
       
    </head>
  <script type="text/javascript">
  function clear(){
	  document.getElementById("file").value = "";
  }
  
  </script>
 <body bgcolor="#9933FF">
<br><br><br><br><br><br><br>
    <center>
        <div>
            <h3> <label>Choose File to Upload in Server</label> </h3>
            <form action="upload" method="post" enctype="multipart/form-data">
            <table id="rcorners1"align="center">
            <tr>
            <td colspan=2>
                <input type="file" name="file" required placeholder="Please choose file"/>
                </td></tr>
                <tr><td align="center"><input type="submit" value="Upload" /></td><td><input type="reset" value="Clear" onclick="clear()" /></td></tr>
                
                </table>
            </form>          
        </div>
       </center>
    </body>
</html>