var hakusana;
hakusana = decodeURIComponent(window.location.hash.substring(1));
var jarjestys = document.getElementsByClassName("levy");
var jsonId;
$(document).ready(function() {
	if (nykyinenSivu != "welcome" && nykyinenSivu != "login") {
		var sivuLinkki = document.getElementsByClassName(nykyinenSivu)[0];
		sivuLinkki.classList.add("nyt");
	}
	tinysort(jarjestys);
	sivutus();
	if (nykyinenSivu == "naytaLevy") {
		lataaKuvat();
	}
	$.fn.arvosanaTahdiksi = function() {
		return $(this).each(function() {
			var val = parseFloat($(this).html());
			var tahdet = '<span class="r5">☆</span><span class="r4">☆</span><span class="r3">☆</span><span class="r2">☆</span><span class="r1">☆</span>';
			var i = 0;
			var pos;
			while (i < val) {
				pos = tahdet.lastIndexOf('☆');
				tahdet = tahdet.substring(0, pos) + '★' + tahdet.substring(pos + 1)
				i++;
			}
			$(this).html(tahdet);
		});
	}
	$('.arvostelu').arvosanaTahdiksi();
	if (hakusana != "" && hakusana != "muokkaa") {
		$('.oikee input').val(hakusana);
		fadeHaku();
	} else {
		$("#levyt").animate({
			"opacity": 1
		});
	}
	$("#resetoiHaku").click(function() {
		$('.oikee input').val("");
		hakuTyhjennys();
	});
	$('#muokkaaLevy').data('alkup', $('#muokkaaLevy').html());
	$('.otsikko').data('alkupOtsikko', $('.otsikko').html());
	$('.artisti').data('alkupArtisti', $('.artisti').html());
	$('.julkaisuVuosi').data('alkupJulkaisuVuosi', $('.julkaisuVuosi').html());
	$('.levyGenre').data('alkupGenre', $('.levyGenre').html());
	$('.levytunnus').data('alkupLevytunnus', $('.levytunnus').html());
	$('.levyMaara').data('alkupLevyMaara', $('.levyMaara').html());
	$('.levyTyyppi').data('alkupLevyTyyppi', $('.levyTyyppi').html());
	$('#muutaTietoa').data('alkupMuutaTietoa', $('#muutaTietoa').html());
	$('.arvosana').data('alkupArvosana', $('.arvosana').html());
	$('.levyKunto').data('alkupLevyKunto', $('.levyKunto').html());
	$('.kansiKunto').data('alkupKansiKunto', $('.kansiKunto').html());
	$('.tallennaperuuta').hide();
	piilotaMuokkaus();
	if (window.location.hash == "#muokkaa") {
		naytaMuokkaus();
	}
	$(document).delegate('#muokkaaLevy', 'click', function(event) {
		if ($(event.target).parent().attr('class') == "muokkaa") {
			naytaMuokkaus();
		}
		if ($(event.target).parent().attr('class') == "peruuta") {
			piilotaMuokkaus();
		}
	});
	$("#lisaaLevy").validate();
	$("#login").validate();
	$('.tallenna').click(function() {
		$("#levyMuokkaus").validate();
		if ($("#levyMuokkaus").valid) {
			$('#levyMuokkaus').submit();
		}
	});
	$('.poista').click(function() {
		poistetaanko = confirm(poistetaanko);
		if (poistetaanko == true) {
			$('#levyPoisto').submit();
		} else {
			poistetaanko = poistetaanko2;
		}
	});
	$(document).delegate('.arvostelu span', 'click', function(event) {
		if (muokkaaLevy == true) {
			var text = $(this).parent().text();
			var input = $(this).parent().attr('name');
			if ($(event.target).attr('class') == "r1") {
				if (text == '☆☆☆☆★') {
					$(this).parent().html('<span class="r5">☆</span><span class="r4">☆</span><span class="r3">☆</span><span class="r2">☆</span><span class="r1">☆</span>');
					$('input#' + input).val('0');
				} else {
					$(this).parent().html('<span class="r5">☆</span><span class="r4">☆</span><span class="r3">☆</span><span class="r2">☆</span><span class="r1">★</span>');
					$('input#' + input).val('1');
				}
			}
			if ($(event.target).attr('class') == "r2") {
				if (text == '☆☆☆★★') {
					$(this).parent().html('<span class="r5">☆</span><span class="r4">☆</span><span class="r3">☆</span><span class="r2">☆</span><span class="r1">☆</span>');
					$('input#' + input).val('0');
				} else {
					$(this).parent().html('<span class="r5">☆</span><span class="r4">☆</span><span class="r3">☆</span><span class="r2">★</span><span class="r1">★</span>');
					$('input#' + input).val('2');
				}
			}
			if ($(event.target).attr('class') == "r3") {
				if (text == '☆☆★★★') {
					$(this).parent().html('<span class="r5">☆</span><span class="r4">☆</span><span class="r3">☆</span><span class="r2">☆</span><span class="r1">☆</span>');
					$('input#' + input).val('0');
				} else {
					$(this).parent().html('<span class="r5">☆</span><span class="r4">☆</span><span class="r3">★</span><span class="r2">★</span><span class="r1">★</span>');
					$('input#' + input).val('3');
				}
			}
			if ($(event.target).attr('class') == "r4") {
				if (text == '☆★★★★') {
					$(this).parent().html('<span class="r5">☆</span><span class="r4">☆</span><span class="r3">☆</span><span class="r2">☆</span><span class="r1">☆</span>');
					$('input#' + input).val('0');
				} else {
					$(this).parent().html('<span class="r5">☆</span><span class="r4">★</span><span class="r3">★</span><span class="r2">★</span><span class="r1">★</span>');
					$('input#' + input).val('4');
				}
			}
			if ($(event.target).attr('class') == "r5") {
				if (text == '★★★★★') {
					$(this).parent().html('<span class="r5">☆</span><span class="r4">☆</span><span class="r3">☆</span><span class="r2">☆</span><span class="r1">☆</span>');
					$('input#' + input).val('0');
				} else {
					$(this).parent().html('<span class="r5">★</span><span class="r4">★</span><span class="r3">★</span><span class="r2">★</span><span class="r1">★</span>');
					$('input#' + input).val('5');
				}
			}
		}
	});
	$.fn.haeKappalelista = function() {
		var artisti = $(this).attr("name");
		var levy = $(this).attr("title")
		var that = this;
		var raja;
		var i;
		var levyId = null;
		var musicbrainzAPI;
		var json;
		var timeOut = 1000; // MusicBrainz rajoittaa pyynnöt yhteen per sekunti
		i = 0;
		var intr = setInterval(function() {
			musicbrainzAPI = "http://musicbrainz.org/ws/2/release-group/?query=artist:\"" + artisti + "\"&inc=releases&fmt=json&limit=100&offset=" + i * 100;
			json = $.ajax({
				url: musicbrainzAPI,
				async: false,
				timeout: 10000,
				dataType: 'json',
				error: function() {
					$(that).html(kappalelistaVirhe);
				}
			});
			try {
				json = jQuery.parseJSON(json.responseText);
				$.each(json['release-groups'], function(i, v) {
					if (v.releases[0]['title'].toLowerCase() == levy.toLowerCase()) {
						levyId = v.releases[0]['id'];
						return false;
					}
				});
				raja = json['count'];
				if(raja == 0) {
					$(that).html(kappalelistaVirhe);
					clearInterval(intr);
				}
			} catch (e) {
				$(that).html(kappalelistaVirhe);
				clearInterval(intr);
			}
			if (++i == raja || levyId != null) {
				clearInterval(intr);
				setTimeout(function() {
					musicbrainzAPI = "http://musicbrainz.org/ws/2/release/" + levyId + "?inc=recordings&fmt=json&limit=100";
					json = $.ajax({
						url: musicbrainzAPI,
						async: false,
						timeout: 10000,
						dataType: 'json',
						error: function() {
							$(that).html(kappalelistaVirhe);
						}
					});
					try {
						json = jQuery.parseJSON(json.responseText);
						if (json.hasOwnProperty('error')) {
							$(that).html(kappalelistaVirhe);
						} else {
							$(that).slideUp(200, function() {
								$(this).html("");
								$.each(json['media'][0]['tracks'], function(i, v) {
									$(that).append('<li style="display:none">' + v.recording.title + '</li>');
								});
								$(this).slideDown(300);
								$("li", that).each(function(i) {
									$(this).fadeIn(250 * i);
								});
							});
						}
					} catch (e) {
						$(that).html("Error");
					}
				}, timeOut);
			}
		}, timeOut)
	}
	if ($('#kappalelista').length) {
		$("#kappalelista").haeKappalelista();
	}
	$('.oikee input').keypress(function(e) {
		if (e.which == 13) {
			hakusana = $('.oikee input').val();
			window.location.href = "/musiikkikokoelma/levyt/#" + hakusana;
			fadeHaku();
			return false;
		}
	});
	$("#hae").click(function() {
		hakusana = $('.oikee input').val();
		window.location.href = "/musiikkikokoelma/levyt/#" + hakusana;
		fadeHaku();
	});
});

function lataaKuvat() {
	$(".levykuva:visible").each(function(i) {
		var that = this;
		setTimeout(function() {
			if ($(".kuva", that).attr("name") === "eiladattu") {
				var id = $(that).attr("id");
				var url;
				var lastfmAPI = "/musiikkikokoelma/resources/json/" + id + '?_=' + (new Date()).getTime();
				var json = $.ajax({
					url: lastfmAPI,
					async: false,
					timeout: 800,
					dataType: 'json',
					error: function() {
						lastfmAPI = "/musiikkikokoelma/resources/json/" + id + '?_=' + (new Date()).getTime();
						$.get("/musiikkikokoelma/levyt/levykuva", {
							id: id,
							u: 0
						});
						url = "/musiikkikokoelma/resources/images/eikuvaa.png";
						$(".kuva", that).attr("src", url, function() {
							$(".kuva", that).removeAttr("name");
						});
						$(".kuva", that).animate({
							"opacity": "1"
						});
						$(".placeholder", that).animate({
							"opacity": "0"
						});
					}
				}).retry({
					times: 4
				}).done(function(json) {
					if (json.hasOwnProperty('error')) {
						url = "/musiikkikokoelma/resources/images/eikuvaa.png";
					} else {
						url = json.album.image[3]["#text"];
					}
					$(".kuva", that).attr("src", url, function() {
						$(".kuva", that).removeAttr("name");
					});
					$(".kuva", that).animate({
						"opacity": "1"
					});
					$(".placeholder", that).animate({
						"opacity": "0"
					}, function() {
						$(".placeholder", that).attr("src", "/musiikkikokoelma/resources/images/eikuvaa.png");
					});
				});
			}
		}, 300 * i);
	});
}

function sivutus() {
	$('.sivutus').hide();
	$('.sivutus').jPages({
		containerID: "levyt",
		perPage: 9,
		first: "≪",
		last: "≫",
		next: "＞",
		previous: "＜",
		callback: function() {
			$('html').animate({
				scrollTop: 0
			}, 'fast');
			$('body').animate({
				scrollTop: 0
			}, 'fast');
			lataaKuvat();
		}
	});
	if (!$(".jp-current").length) {
		$('#eiTuloksia').fadeIn();
		$('.sivutus').hide();
	} else {
		$('#eiTuloksia').fadeOut();
		$('.sivutus').fadeIn();
	}
}

function hae() {
	$(".levy").detach().appendTo('#levyt');
	$('.sivutus').jPages("destroy");
	tinysort(jarjestys);
	$.when($('.levy').each(function() {
		if ($(this).text().toUpperCase().indexOf(hakusana.toUpperCase()) == -1) {
			$(this).detach().appendTo('#piilotetut');
		}
	})).then(function() {
		sivutus();
	});
}

function hakuTyhjennys() {
	tinysort(jarjestys);
	$("#levyt").animate({
		"opacity": 0
	}, function() {
		$.when($('.sivutus').jPages("destroy")).then(function() {
			sivutus();
		});
		$(".levy").detach().appendTo('#levyt');
		$("#levyt").delay(400).animate({
			"opacity": 1
		});
	});
	$('#resetoiHaku').css({
		"opacity": 0
	});
}

function fadeHaku() {
	if (hakusana != "") {
		$('#resetoiHaku').css({
			"opacity": 1
		});
		$.when($("#levyt").animate({
			"opacity": 0
		}, function() {
			hae();
		})).then(function() {
			$("#levyt").animate({
				"opacity": 1
			});
		});
	} else {
		hakuTyhjennys();
	}
}

function naytaMuokkaus() {
	muokkaaLevy = true;
	$('.tallennaperuuta').fadeIn();
	$('.muokkaa').fadeOut();
	$("#levytiedot input").prop('disabled', false);
	$("#muutaTietoa input").prop('disabled', false);
	$("#levytiedot select").prop('disabled', false);
	$("#artistiHaku").hide();
	$('#muutaTietoa').show();
}

function piilotaMuokkaus() {
	muokkaaLevy = false;
	$('.tallennaperuuta').fadeOut();
	$('.muokkaa').fadeIn();
	$('.otsikko').html($('.otsikko').data('alkupOtsikko'));
	$('.artisti').html($('.artisti').data('alkupArtisti'));
	$('.julkaisuVuosi').html($('.julkaisuVuosi').data('alkupJulkaisuVuosi'));
	$('.levyGenre').html($('.levyGenre').data('alkupGenre'));
	$('.levytunnus').html($('.levytunnus').data('alkupLevytunnus'));
	$('.levyMaara').html($('.levyMaara').data('alkupLevyMaara'));
	$('.levyTyyppi').html($('.levyTyyppi').data('alkupLevyTyyppi'));
	$('#muutaTietoa').html($('#muutaTietoa').data('alkupMuutaTietoa'));
	$('.arvosana').html($('.arvosana').data('alkupArvosana'));
	$('.levyKunto').html($('.levyKunto').data('alkupLevyKunto'));
	$('.kansiKunto').html($('.kansiKunto').data('alkupKansiKunto'));
	$("#levytiedot input").prop('disabled', true);
	$("#levytiedot select").prop('disabled', true);
	if (!$("input[name='muutaTietoa']").val()) {
		$('#muutaTietoa').hide();
	}
}

function artistiHaku() {
	var li, i;
	var input = document.getElementById("artistiHaku");
	var filter = input.value.toUpperCase();
	var ul = document.getElementById("artistiLista");
	var a = ul.getElementsByTagName("a");
	for (i = 0; i < a.length; i++) {
		li = a[i].getElementsByTagName("li")[0];
		if (li.getElementsByTagName("span")[0].innerHTML.toUpperCase().indexOf(filter) > -1) {
			a[i].style.display = "";
		} else {
			a[i].style.display = "none";
		}
	}
}