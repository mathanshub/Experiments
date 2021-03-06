<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.util.*,java.text.*"%>
<%@page import="com.search.DTOs.ServerDTO"%>
<%@ page import="java.util.Calendar;"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="refresh" content="5" />

<title>Monitor Servers</title>
<link rel="stylesheet" href="styles/styles.css" type="text/css" />
</head>
<%
			Map<String, List<ServerDTO>> map = (Map<String, List<ServerDTO>>) request.getAttribute("Map");
%>
<SCRIPT LANGUAGE="JavaScript">
<!--
	var myArray = new Array(<%=map.size()%>);
	<% 
   		Iterator it1=map.entrySet().iterator();
		int serverCount = 0;
		while(it1.hasNext()){
			Map.Entry pairs1 =(Map.Entry)it1.next();
			List<ServerDTO> temp1 = (List<ServerDTO>)pairs1.getValue();
			int size=temp1.size();
	%>
			myArray[<%=serverCount%>] = new Array(<%=size%>);
	<%
			for (int j = 0; j < size; j++) {
				ServerDTO serverDTO = temp1.get(j);
	%>
				var theStatus = new Object;
				theStatus.hostname = '<%=serverDTO.getHost_name()%>';
				theStatus.type = '<%=serverDTO.getType()%>';
				theStatus.region = '<%=serverDTO.getRegion()%>';
				theStatus.ipaddress = '<%=serverDTO.getIp_address()%>';
				theStatus.nodestatus = '<%=serverDTO.getNode_state()%>';
				myArray[<%=serverCount%>][<%=j%>] = theStatus;
		
	<%
			}
			serverCount++;
		}
	%>
	
	
 
 
function test()
{
	alert("test");
}
	
	
function populateContentByValues(server,beg,end)
{
	var htmlContent = "";
	var myArrayLocal = myArray[server];
	if (typeof beg == 'undefined'){
		var beg=1;
	}
	if (typeof end == 'undefined'){	
		var	end=myArrayLocal.length;
	}	
	
		
	for (var i = 0; i < 9; i++) {
		
		if( i==0 || i%3 == 0){
			htmlContent = htmlContent+'<div class="tableRowData">';
		}
        htmlContent = htmlContent +'<div class="tableCellData">';
		htmlContent = htmlContent +'   <div class="tableCellImageData">';
		if(beg<=end){
			var status=trim(myArray[server][beg-1].nodestatus);
			if( status.toString() == 'UEA' || status.toString() == 'UEI' ){
				htmlContent = htmlContent + '    	<img src="Images/UEA.gif" alt="This is  working" width="100%" height="100%" />';
			}
			else if( status.toString() == 'UEIm'){	
				htmlContent = htmlContent + '    	<img src="Images/UEIm.gif" alt="This is not  working" width="100%" height="100%" />';
			}		
			
			else if( status.toString() == 'UEB'){	
				htmlContent = htmlContent + '    	<img src="Images/UEB.gif" alt="This is  working" width="100%" height="100%" />';
			}	
			else if( status.toString() == 'LDI' || status.toString() == 'LEI'){	
				htmlContent = htmlContent + '    	<img src="Images/LDI.gif" alt="This is  working" width="100%" height="100%" />';
			}	
			else{
				htmlContent = htmlContent + '    	<img src="Images/Blue.gif" alt="This is  working" width="100%" height="100%" />';
			}
		}	
		htmlContent = htmlContent +'  </div>';
		htmlContent = htmlContent +'  <div class="tableCellTextData">';
		if(beg<=end){
			htmlContent = htmlContent +myArray[server][beg-1].hostname;
		}
		htmlContent = htmlContent +' </div>';
		htmlContent = htmlContent +' </div>';
		if((i+1)%3 == 0){
			htmlContent = htmlContent+'</div>';
		}
		beg++;
					 
	}
	var obj = document.getElementById("tableDataId");
	obj.innerHTML = htmlContent;
}
		
function populateContent()
{
	var server=0;
	var htmlContent = "";
	var myArrayLocal = myArray[server];
	var beg=1;
	var	end=myArrayLocal.length;
	
		
	for (var i = 0; i < 9; i++) {
		
		if(i==0 || i%3 == 0){
			htmlContent = htmlContent+'<div class="tableRowData">';
		}
        htmlContent = htmlContent +'<div class="tableCellData">';
		htmlContent = htmlContent +'   <div class="tableCellImageData">';
		if(beg<=end){
			var status=trim(myArray[server][beg-1].nodestatus);
			if( status.toString() == 'UEA' || status.toString() == 'UEI' ){
				htmlContent = htmlContent + '    	<img src="Images/UEA.gif" alt="This is  working" width="100%" height="100%" />';
			}
			else if( status.toString() == 'UEIm'){	
				htmlContent = htmlContent + '    	<img src="Images/UEIm.gif" alt="This is  working" width="100%" height="100%" />';
			}		
			
			else if( status.toString() == 'UEB'){	
				htmlContent = htmlContent + '    	<img src="Images/UEB.gif" alt="This is  working" width="100%" height="100%" />';
			}	
			else if( status.toString() == 'LDI' || status.toString() == 'LEI'){	
				htmlContent = htmlContent + '    	<img src="Images/LDI.gif" alt="This is  working" width="100%" height="100%" />';
			}
			else{
				htmlContent = htmlContent + '    	<img src="Images/Blue.gif" alt="This is  working" width="100%" height="100%" />';
			}
				
		}	
		htmlContent = htmlContent +'  </div>';
		htmlContent = htmlContent +'  <div class="tableCellTextData">';
		if(beg<=end){
			htmlContent = htmlContent +myArray[server][beg-1].hostname;
		}
		htmlContent = htmlContent +' </div>';
		htmlContent = htmlContent +' </div>';
		if((i+1)%3 == 0 ){
			htmlContent = htmlContent+'</div>';
		}
		beg=beg+1;
					 
	}
	var obj = document.getElementById("tableDataId");
	obj.innerHTML = htmlContent;
}

function objectToString(o){
    
    var parse = function(_o){
    
        var a = [], t;
        
        for(var p in _o){
        
            if(_o.hasOwnProperty(p)){
            
                t = _o[p];
                
                if(t && typeof t == "object"){
                
                    a[a.length]= p + ":{ " + arguments.callee(t).join(", ") + "}";
                    
                }
                else {
                    
                    if(typeof t == "string"){
                    
                        a[a.length] = [ p+ ": \"" + t.toString() + "\"" ];
                    }
                    else{
                        a[a.length] = [ p+ ": " + t.toString()];
                    }
                    
                }
            }
        }
        
        return a;
        
    }
    
    return "{" + parse(o).join(", ") + "}";
    
}
// Removes leading whitespaces
function LTrim( value ) {
	
	var re = /\s*((\S+\s*)*)/;
	return value.replace(re, "$1");
	
}

// Removes ending whitespaces
function RTrim( value ) {
	
	var re = /((\s*\S+)*)\s*/;
	return value.replace(re, "$1");
	
}

// Removes leading and ending whitespaces
function trim( value ) {
	
	return LTrim(RTrim(value));
	
}
//-->
</SCRIPT>

<%
Calendar now = Calendar.getInstance();
int D_hour=now.get(Calendar.HOUR);
int D_minute=now.get(Calendar.MINUTE);
int D_sec=now.get(Calendar.SECOND);

now.add(Calendar.MINUTE, 2);
int N_hour=now.get(Calendar.HOUR);
int N_minute=now.get(Calendar.MINUTE);
int N_sec=now.get(Calendar.SECOND);
%>

<body onload="populateContent();">

<div class="container">
	<div class="header"><!-- end .header -->
		<img src="Images/Banner.jpg" width="800" height="99" />
	</div>
	<div class="subHeading">
			<div class="fltlft"><img src="Images/TransRef.gif" width="278"
					height="1" />
			</div>
			<div class="timers"><input name="DT" type="text" id="DT"
					value="Downloaded Time: <%=D_hour %>:<%=D_minute%>:<%=D_sec %> " />
			</div>
			<div class="fltlft"><img src="Images/TransRef.gif" width="96"
					height="1" />
			</div>
			<div class="timers"><input name="ET" type="text" id="ET"
					value="Elapsed Time: <%=N_hour %>:<%=N_minute%>:<%=N_sec %>" />
			</div>
	</div>
	<div class="sidebar1">
		<ul id="nav">
			<%
				Iterator it = map.entrySet().iterator();
				serverCount = 0;
				while (it.hasNext()) {
					Map.Entry pairs = (Map.Entry) it.next();
					List<ServerDTO> temp = (List<ServerDTO>) pairs.getValue();
					int size = temp.size();
					int beg = 1;
					int end = 9;
			%>
			<li>
			<%
				if (temp.size() > 9) {
			%> <a><%=pairs.getKey()%></a>
			<%
 				} else {
 			%>

			<a href="#" onclick="populateContentByValues('<%=serverCount%>');"><%=pairs.getKey()%></a>
			<%
				}
			%>
			
			<%
 				if (temp.size() > 9) {
 			%>
			<ul>
			<%
				while (size > 0) {
			%>
				<li><a href="#"
					onclick="populateContentByValues('<%=serverCount%>','<%=beg%>','<%=end %>');"><%=beg%>
					to <%=end%> Systems</a></li>
				<%
					size -= 9;
					beg = end + 1;
					if (size > 9) {
						end += 9;
					} else
						end = end + size;
				%>
			<%
			}
			%>
			</ul>
		<%
		}
		%>
		</li>
		<%
			serverCount++;
			}
		%>
	 </ul>
<!-- end .sidebar1 -->
   </div>
	<div class="content">
		<div class="tableData" id="tableDataId">
		</div>
	</div>

<!--   <div class="footer"><p>This is footer</p></div> --> <!-- end .container -->
</div>
</body>
</html>
