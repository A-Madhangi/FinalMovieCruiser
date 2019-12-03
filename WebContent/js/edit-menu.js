
function validateMenuItem()
{
	
	var title=document.forms["editMenuForm"]["mname"].value;
	var price=document.forms["editMenuForm"]["boxoffice"].value;
	var dol=document.forms["editMenuForm"]["launch"].value;
	var cate=document.forms["editMenuForm"]["genre"].value;
	
	if(title== "")
	{ 
	alert("title is required");
	return false;
	}
 	else if(title.length<2 || title.length>65)
	{
	alert("tile should have 2 to 65 characters");
	return false;
	}
	else if(price == "")
	{
	alert("Box office is required"); 
	return false;
	}
	else if(isNaN(price))
	{
	alert("Box office has to be number");
	return false;
	}
	else if(dol == "")
	{
	alert("Date of launch is empty");
	return false;
	}
	else if(cate == "empty")
	{
	alert("Genre is empty");
	return false;
	}
	
}
