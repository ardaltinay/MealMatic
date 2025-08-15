let selectedItem = '';
function openModal(item) {
    selectedItem = item;
    document.getElementById('modalItemName').innerText = 'Add ' + item;
    document.getElementById('itemQty').value = 1;
    const modal = new bootstrap.Modal(document.getElementById('addItemModal'));
    modal.show();
}
function confirmAdd() {
    const qty = document.getElementById('itemQty').value;
    const infoId = selectedItem.toLowerCase() + 'Info';
    document.getElementById(infoId).innerText = `Added: ${qty}`;
    bootstrap.Modal.getInstance(document.getElementById('addItemModal')).hide();
}
function removeItem(id) {
    const row = document.getElementById('item-' + id);
    if (document.getElementById(id + 'Info')) {
        document.getElementById(id + 'Info').innerText = '';
    }
}
const grid = document.getElementById("tableGrid");
grid.querySelectorAll('.table-item').forEach(item => {
    item.addEventListener('click', () => {
        grid.querySelectorAll('.table-item').forEach(i => i.classList.remove('selected'));
        item.classList.add('selected');
    });
});

function submitLoginForm() {
    $.post('/login', {
        tckn: $('#loginForm input[name="tckn"]').val(),
        pass: $('#loginForm input[name="pass"]').val()
    }, function(data) {
        if (data.success) {
            window.location.href = '/tables';
        } else {
            $("#loginErrorModal .modal-body").text(data.message);
            $("#loginErrorModal").modal("show");
        }
    });
}

function submitAddProductForm() {
    $.post('/admin/create-product', {
        name: $('#addProductForm input[name="name"]').val(),
        description: $('#addProductForm input[name="description"]').val(),
        price: $('#addProductForm input[name="price"]').val(),
        category: $('#addProductForm select[name="category"]').val(),
        type: $('#addProductForm select[name="type"]').val(),
    }, function(data) {
        if (data.success) {
            $('#addProductModal').modal('hide');
            alert("Product created successfully!");
        } else {
            $("#loginErrorModal .modal-body").text("Error while creating Product object!");
            $("#loginErrorModal").modal("show");
        }
    });
}

function deleteProduct(id) {
    $.delete('/admin/delete-product/' + id, function(data) {
            if (data.success) {
                alert("Product deleted successfully!");// Refresh the product list
            } else {
                $("#loginErrorModal .modal-body").text("Error while deleting Product object!");
                $("#loginErrorModal").modal("show");
            }
        }, function() {
            $("#loginErrorModal .modal-body").text("Error while deleting Product object!");
            $("#loginErrorModal").modal("show");
        }
    );
}

function editProduct(id) {
    $.get('/admin/get-product/' + id, function(data) {
        $('#editProductForm input[name="id"]').val(data.product.id);
        $('#editProductForm input[name="name"]').val(data.product.name);
        $('#editProductForm input[name="description"]').val(data.product.description);
        $('#editProductForm input[name="price"]').val(data.product.price);
        $('#editProductForm select[name="category"]').val(data.product.category);
        $('#editProductForm select[name="type"]').val(data.product.type);
        $('#editProductModal').modal('show');
    });
}

function submitEditProductForm() {
    $.post('/admin/update-product', {
        id: $('#editProductForm input[name="id"]').val(),
        name: $('#editProductForm input[name="name"]').val(),
        description: $('#editProductForm input[name="description"]').val(),
        price: $('#editProductForm input[name="price"]').val(),
        category: $('#editProductForm select[name="category"]').val(),
        type: $('#editProductForm select[name="type"]').val(),
    }, function(data) {
        if (data.success) {
            $('#editProductModal').modal('hide');
            alert("Product updated successfully!");
        } else {
            $("#loginErrorModal .modal-body").text("Error while updating Product object!");
            $("#loginErrorModal").modal("show");
        }
    });
}
