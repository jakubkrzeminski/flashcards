$('document').ready(function(){
    $('a[name="editButton"]').on('click',function(event){
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(flashcard, status) {
            $('#idEdit').val(flashcard.id);
            $('#frontEdit').val(flashcard.front);
            $('#backEdit').val(flashcard.back);
        });

        $('#editModal').modal("show");
    });
})