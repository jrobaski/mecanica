$(document).ready(function(){
	var braImgLink = "http://www.roemheld.de/IT/Data/Images/Address/Brasilien.gif";
	var engImgLink = "http://www.roemheld.de/IT/Data/Images/Address/Grossbritanien.gif";

	var imgBtnSel = $('#imgBtnSel');
	var imgBtnBra = $('#imgBtnBra');
	var imgBtnEng = $('#imgBtnEng');

	var imgNavSel = $('#imgNavSel');
	var imgNavBra = $('#imgNavBra');
	var imgNavEng = $('#imgNavEng');

	var spanNavSel = $('#lanNavSel');
	var spanBtnSel = $('#lanBtnSel');

	imgBtnSel.attr("src",braImgLink);
	imgBtnBra.attr("src",braImgLink);
	imgBtnEng.attr("src",engImgLink);

	imgNavSel.attr("src",braImgLink);
	imgNavBra.attr("src",braImgLink);
	imgNavEng.attr("src",engImgLink);

	$( ".language" ).on( "click", function( event ) {
		var currentId = $(this).attr('id');

		if(currentId == "navBra") {
			imgNavSel.attr("src",braImgLink);
			spanNavSel.text("Bra");
		} else if (currentId == "navEng") {
			imgNavSel.attr("src",engImgLink);
			spanNavSel.text("Eng");
		} 

		if(currentId == "btnBra") {
			imgBtnSel.attr("src",braImgLink);
			spanBtnSel.text("Bra");
		} else if (currentId == "btnEng") {
			imgBtnSel.attr("src",engImgLink);
			spanBtnSel.text("Eng");
		}

	});
});