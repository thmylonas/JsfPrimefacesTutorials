$(document).ready(function () {
    $('#btn').submit(function (e) {
        // reference to form object
        let form = this;
        // for stopping the default action of element
        e.preventDefault();
        // A map which will hold form data
        let formData = {};
        //iterate over form elements
        $.each(this, function (i, v) {
            let input = $(v);
            // populate form data as key-value pairs
            // with the name of input as key and its value as value
            formData[input.attr("name")] = input.val();
        });
        $.ajax({
            type: form.attr('method'), // method attribute of form
            url: form.attr('action'),  // action attribute of form
            dataType: 'json',
            // convert form data to json format
            data: JSON.stringify(formData),
        });
    });
})

$("#asd").submit(function (e) {
    console.log("The event " + e + " is not used in this function!");
    $.ajax({
        url: 'http://localhost:8080/MySpringHibernateJsfWebApp/java/java-java-se-ge8/java-java-se-8-streams/java-java-se-8-streams-filter-examples',
        type: 'post',
        data: $(this).serialize(),
        success: function () {
            alert('success');
        }
    })
});
