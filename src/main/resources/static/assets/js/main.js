
(function ($) {
"use strict";


    // Loading Box (Preloader)
    function handlePreloader() {
        if ($('.preloader').length) {
            $('.preloader').delay(200).fadeOut(500);
        }
    }


    // Header Style and Scroll to Top
    function headerStyle() {
        if ($('.main-header').length) {
            var windowpos = $(window).scrollTop();
            var siteHeader = $('.main-header');
            var scrollLink = $('.scroll-top');
            if (windowpos >= 250) {
                siteHeader.addClass('fixed-header');
                scrollLink.fadeIn(300);
            } else {
                siteHeader.removeClass('fixed-header');
                scrollLink.fadeOut(300);
            }
        }
    }

    headerStyle();

    // dropdown menu

    var mobileWidth = 991;
    var navcollapse = $('.navigation li.dropdown');

    $(window).on('resize', function () {
        navcollapse.children('ul').hide();
    });

    navcollapse.hover(function () {
        if ($(window).innerWidth() >= mobileWidth) {
            $(this).children('ul').stop(true, false, true).slideToggle(300);
            $(this).children('.megamenu').stop(true, false, true).slideToggle(300);
        }
    });


    //Submenu Dropdown Toggle
    if ($('.navigation li.dropdown ul').length) {
        $('.navigation li.dropdown').append('<div class="dropdown-btn"><span class="fa fa-angle-right"></span></div>');

        //Dropdown Button
        $('.navigation li.dropdown .dropdown-btn').on('click', function () {
            $(this).prev('ul').slideToggle(500);
            $(this).prev('.megamenu').slideToggle(800);
        });

        //Disable dropdown parent link
        $('.navigation li.dropdown > a').on('click', function (e) {
            e.preventDefault();
        });
    }

    //Submenu Dropdown Toggle
    if ($('.main-header .main-menu').length) {
        $('.main-header .main-menu .navbar-toggle').on('click', function () {
            $(this).prev().prev().next().next().children('li.dropdown').hide();
        });

    }
    // End Main menu

    new WOW().init();

        /* Fact Counter + Text Count */
        if ($('.success-box').length) {
            $('.success-box').appear(function () {

                var $t = $(this),
                    n = $t.find(".count-text").attr("data-stop"),
                    r = parseInt($t.find(".count-text").attr("data-speed"), 10);

                if (!$t.hasClass("counted")) {
                    $t.addClass("counted");
                    $({
                        countNum: $t.find(".count-text").text()
                    }).animate({
                        countNum: n
                    }, {
                        duration: r,
                        easing: "linear",
                        step: function () {
                            $t.find(".count-text").text(Math.floor(this.countNum));
                        },
                        complete: function () {
                            $t.find(".count-text").text(this.countNum);
                        }
                    });
                }

            }, {
                accY: 0
            });
        }

    
    /*========== Start Portfolio isotop Js ==========*/
    // isotop
    // init Isotope
    var $grid = $('.custom-row').isotope({
        itemSelector: '.grid-item',
        percentPosition: true,
        masonry: {
            // use outer width of grid-sizer for columnWidth
            columnWidth: 1,
        }
    });
    


    // magnificPopup
    if ($('.projects-popup-link').length) {
        $('.projects-popup-link').magnificPopup({
            type: 'image',
            gallery: {
                enabled: true
            },
        });
    }

    

    
    


    /*============================== start video element     ========================================*/

    // magnificPopup start
    $('.vedio-play').magnificPopup({
        type: 'video',
    });
    // magnificPopup end



    //service-carousel
    if ($('.service-carousel').length) {
        $('.service-carousel').owlCarousel({
            loop:true,
            items: 3,
            margin: 20,
            nav: false,
            dots: true,
            active: true,
            dotsEach: 2,
            smartSpeed: 1000,
            autoplay: 5000,
            responsive: {
                0: {
                    items: 1,
                },
                575: {
                    items: 1,
                },
                768: {
                    items: 2,
                },
                992: {
                    items: 3,
                },
                1200: {
                    items: 3,
                }
            }
        });
    }

    

    //team-carousel
    if ($('.team-carousel').length) {
        $('.team-carousel').owlCarousel({
            loop:true,
            items: 3,
            margin: 20,
            nav: true,
            dots: false,
            active: true,
            dotsEach: 2,
            smartSpeed: 1000,
            autoplay: 5000,
            navText: ['<span class="flaticon-left-arrow"></span>', '<span class="flaticon-right-arrow"></span>'],
            responsive: {
                0: {
                    items: 1,
                },
                575: {
                    items: 1,
                },
                768: {
                    items: 2,
                },
                992: {
                    items: 3,
                },
                1200: {
                    items: 3,
                }
            }
        });
    }

    


    // Scroll to a Specific Div
    if ($('.scroll-to-target').length) {
        $(".scroll-to-target").on('click', function () {
            var target = $(this).attr('data-target');
            // animate
            $('html, body').animate({
                scrollTop: $(target).offset().top
            }, 1000);

        });
    }
    
    
    
    $('.testi-image-wrap').slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        asNavFor: '.testi-content-wrap',
        dots: false,
        focusOnSelect: true,
        prevArrow: '<i class="flaticon-left-arrow left"></i>',
        nextArrow: '<i class="flaticon-right-arrow right"></i>',
        responsive: [
            {
              breakpoint: 500,
              settings: {
                slidesToShow: 1,
              }
            },
        ]
    });
    
    
    $('.testi-content-wrap').slick({
        asNavFor: '.testi-image-wrap',
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        fade: true,
        dots: false,
    });
    
    
    
    $('.testimonial-two-wrap').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: true,
        fade: true,
        dots: false,
        autoplay: true,
        prevArrow: '<i class="flaticon-left-arrow left"></i>',
        nextArrow: '<i class="flaticon-right-arrow right"></i>',
    });
    
    
    

    /* ==========================================================================
       When document is scroll, do
       ========================================================================== */

    $(window).on('scroll', function () {
        headerStyle();
    });

    /* ==========================================================================
       When document is loaded, do
       ========================================================================== */

    $(window).on('load', function () {
        handlePreloader();

        
        
        
    /*========== Start Portfolio isotop Js ==========*/
    // isotop
    // init Isotope
    var $grid = $('.custom-row').isotope({
        itemSelector: '.grid-item',
        percentPosition: true,
        masonry: {
            // use outer width of grid-sizer for columnWidth
            columnWidth: 1,
        }
    });
    

    });


})(jQuery);