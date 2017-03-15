<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>About Us</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

<script>

    $(function() {
        $("#accordion").accordion({
            event : "click hoverintent"
        });
    });
    /*
     * hoverIntent | Copyright 2011 Brian Cherne
     * http://cherne.net/brian/resources/jquery.hoverIntent.html
     * modified by the jQuery UI team
     */
$.event.special.hoverintent = {
        setup : function() {
            $(this).bind("mouseover", jQuery.event.special.hoverintent.handler);
        },
        teardown : function() {
            $(this).unbind("mouseover",
                    jQuery.event.special.hoverintent.handler);
        },
        handler : function(event) {
            var currentX, currentY, timeout, args = arguments, target = $(event.target),

            previousX = event.pageX, previousY = event.pageY;
            function track(event) {
                currentX = event.pageX;
                currentY = event.pageY;
            }
            ;
            function clear() {
                target.unbind("mousemove", track).unbind("mouseout", clear);
                clearTimeout(timeout);
            }
            function handler() {
                var prop, orig = event;
                if ((Math.abs(previousX - currentX) + Math.abs(previousY
                        - currentY)) < 7) {
                    clear();
                    event = $.Event("hoverintent");
                    for (prop in orig) {
                        if (!(prop in event)) {
                            event[prop] = orig[prop];
                        }
                    }

                    // Prevent accessing the original event since the new event
                    // is fired asynchronously and the old event is no longer
                    // usable (#6028)
                    delete event.originalEvent;
                    target.trigger(event);
                } else {
                    previousX = currentX;
                    previousY = currentY;
                    timeout = setTimeout(handler, 100);
                }
            }
            timeout = setTimeout(handler, 100);
            target.bind({
                mousemove : track,
                mouseout : clear
            });
        }
    };
</script>
</head>
<body>
	<fieldset>
		<!-- a table like box to specify the fields -->
		<legend>
			<b><h2>About Us</h2></b>
		</legend>
		<div id="accordion">
			<h3>WE OFFER</h3>
			<div>
				<p>We join clubs or use social networking sites to meet new
					people. But EIU believes In-Person interaction is the best way
					in building long term relations with like minded people. Many of us
					will spend good amount of time behind wheels. Why can't we use this
					commute for an interesting conversation with someone who may become
					your Personal friend?</p>
			</div>
			<h3>WE BELIEVE</h3>
			<div>
				<p>An effective, safe, convenient online car pool matching
					service which helps in finding a mate to commute office or University. You can
					create a pool of like minded students commuting in the same
					direction or nearby locations. A platform to discuss Public
					Transport, Traffic Problems and Improvements.</p>
			</div>
			<h3>OUR EXPERIENCE</h3>
			<div>
				<p> Due to lack of public transport, at EIU students are forced
					to travel by shared and overloaded rental cars/Taxis that ply in these
					areas. Especially, the international students who doesn't own vehicles are facing many difficulties to travel.
					</p>

			</div>
			<h3>OUR AIM</h3>
			<div>
				<p>At EIU CarPool, our aim is to create physical social
					networking of students/staff to avoid traffic chaos and safe
					office commutation resulting in saving Money and cut carbon
					footprint.</p>

			</div>
		</div>
	</fieldset>
</body>
</html>