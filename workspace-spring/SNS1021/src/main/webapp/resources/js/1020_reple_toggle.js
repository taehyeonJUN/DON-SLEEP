$(document).ready( function() {
    $( 'p.a' ).click( function() {
      $( 'p.b' ).toggle( 'slow' );
    });
  });