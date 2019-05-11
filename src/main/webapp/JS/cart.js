function deleteItem(id) {
    var productId = document.getElementById(id).innerHTML;
    $.ajax({
        url: "./CartServletMulti",
        type: "GET",
        data: {productId: productId},
        dataType: "html", success: function (html) {
            location.reload();
        }
    });
}

function changeQuantity(id) {
    var productId = document.getElementById(id).innerHTML;
    var productQuantity = document.getElementById(id + "value").value;

    $.ajax({
        url: "./CartServletMulti",
        type: "GET",
        data: {productId: productId, productQuantity: productQuantity, changeQuantity: true},
        dataType: "html", success: function (html) {
            location.reload();
        }
    });
}

function minus(id) {
    var product = document.getElementById(id + "value");
    var temp = +product.value - 1;
    if (temp < 1) {
        temp = 1;
    }
    product.value = temp;
}

function plus(id) {
    var product = document.getElementById(id + "value");
    var temp = +product.value + 1;
    if (temp > 20) {
        temp = 20;
    }
    product.value = temp;
}
