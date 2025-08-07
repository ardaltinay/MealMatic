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
        tckn: $('input[name="tckn"]').val(),
        pass: $('input[name="pass"]').val()
    }, function(data) {
        if (data.success) {
            window.location.href = '/tables';
        } else {
            $("#loginErrorModal .modal-body").text(data.message);
            $("#loginErrorModal").modal("show");
        }
    });
}