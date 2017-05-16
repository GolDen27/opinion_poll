var choices = $('#switch .choice')
  , text = $('#switch .or')

choices
  .on('click', function(){
    choices.toggleClass('on')
    
    text.addClass('flip')
    setTimeout(function(){
      text.removeClass('flip')
    }, 1000)
  })