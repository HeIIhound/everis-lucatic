// PAGINACION DE TABLA

var $table = document.getElementById("colorInversis"),
// number of rows per page
$n = 15,
// number of rows of the table
$rowCount = $table.rows.length,
// get the first cell's tag name (in the first row)
$firstRow = $table.rows[0].firstElementChild.tagName,
// boolean var to check if table has a head row
$hasHead = ($firstRow === "TH"),
// an array to hold each row
$tr = [],
// loop counters, to start count from rows[1] (2nd row) if the first row has a head tag
$i,$ii,$j = ($hasHead)?1:0,
// holds the first row if it has a (<TH>) & nothing if (<TD>)
$th = ($hasHead?$table.rows[(0)].outerHTML:"");
// count the number of pages
var $pageCount = Math.ceil($rowCount / $n);
// if we had one page only, then we have nothing to do ..
if ($pageCount > 1) {
    // assign each row outHTML (tag name & innerHTML) to the array
    for ($i = $j,$ii = 0; $i < $rowCount; $i++, $ii++)
        $tr[$ii] = $table.rows[$i].outerHTML;
    // create a div block to hold the buttons
    $table.insertAdjacentHTML("afterend","<div id='buttons'></div");
    // the first sort, default page is the first one
    sort(1);
}

// ($p) is the selected page number. it will be generated when a user clicks a button
function sort($p) {
    /* create ($rows) a variable to hold the group of rows
    ** to be displayed on the selected page,
    ** ($s) the start point .. the first row in each page, Do The Math
    */
    var $rows = $th,$s = (($n * $p)-$n);
    for ($i = $s; $i < ($s+$n) && $i < $tr.length; $i++)
        $rows += $tr[$i];
    
    // now the table has a processed group of rows ..
    $table.innerHTML = $rows;
    // create the pagination buttons
    document.getElementById("buttons").innerHTML = pageButtons($pageCount,$p);
    // CSS Stuff
    document.getElementById("id"+$p).setAttribute("class","active");
}


// ($pCount) : number of pages,($cur) : current page, the selected one ..
function pageButtons($pCount,$cur) {
    /* this variables will disable the "Prev" button on 1st page
       and "next" button on the last one */
    var $prevDis = ($cur == 1)?"disabled":"",
        $nextDis = ($cur == $pCount)?"disabled":"",
        /* this ($buttons) will hold every single button needed
        ** it will creates each button and sets the onclick attribute
        ** to the "sort" function with a special ($p) number..
        */
        $buttons = "<input type='button' value='&lt;&lt; Anterior' onclick='sort("+($cur - 1)+")' "+$prevDis+">";
    for ($i=1; $i<=$pCount;$i++)
        $buttons += "<input type='button' id='id"+$i+"'value='"+$i+"' onclick='sort("+$i+")'>";
    $buttons += "<input type='button' value='Siguiente &gt;&gt;' onclick='sort("+($cur + 1)+")' "+$nextDis+">";
    return $buttons;
}


////VALIDACION DE USUARIOLOGIN
//function checkForm(form)
//{
//  // validation fails if the input is blank
//  if(form.user.value == "") {
//    alert("Error: Input is empty!");
//    form.user.focus();
//    return false;
//  }
//
//  // regular expression to match only alphanumeric characters and spaces
//  var re = /^[\w ]+$/;
//
//  // validation fails if the input doesn't match our regular expression
//  if(!re.test(form.user.value)) {
//    alert("Error: Input contains invalid characters!");
//    form.user.focus();
//    return false;
//  }
//
//  // validation was successful
//  return true;
//}
//
//function checkForm(form)
//{
//  if(!condition1) {
//     alert("Error: error message");
//     form.user.focus();
//     return false;
//  }
//  if(!condition2) {
//     alert("Error: error message");
//     form.user.focus();
//     return false;
//  }
//  return true;
//}





//function numerosNegativos(e){ 
//	
//	if (document.extraerForm.cantidad.value>0){ 
//		alert("Debe introducir un número negativo") 
//		return false;
//	}
//	
//   	if (document.extraerForm.cantidad.value==0){ 
//      	alert("Introduzca un cantidad a extraer") 
//      	return false; 
//   	} 
//   	
//   	document.extraerForm.submit(); 
//}
//
//
//function numerosPositivos(e){ 
//	
//	if (document.ingresarForm.cantidad.value<0){ 
//		alert("Debe introducir un número positivo") 
//		return false;
//	}
//	
//   	if (document.ingresarForm.cantidad.value==0){ 
//      	alert("Introduzca un cantidad a ingresar") 
//      	return false; 
//   	} 
//   	
//	document.extraerForm.submit(); 
//}
