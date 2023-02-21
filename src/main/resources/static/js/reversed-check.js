$('document').ready(function(){
    $('[id="check-button"]').on('click',function() {
        var checkButton = document.getElementById("check-button");
        var input = document.getElementById("input");
        var inputValue = input.value;
        var front = document.getElementById("front").attributes.item(1).value;
        var nextButton = document.getElementById("next-button");

        if (inputValue.localeCompare(front) == 0) {
            checkButton.value = "Correct"
            checkButton.innerHTML = "Correct";
            checkButton.style.backgroundColor = "#28a745";
        } else {
            checkButton.value = "Wrong"
            checkButton.innerHTML = "Wrong";
            checkButton.style.backgroundColor = "#dc3545";
            document.getElementById("input").value = document.getElementById("front").attributes.item(1).value;
        }
        checkButton.disabled = true;
        nextButton.disabled = false;
        input.disabled = true;
    });
})