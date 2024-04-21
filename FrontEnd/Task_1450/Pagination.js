const itemsPerPage = 2; //variables
let currentPage = 1;
function fetchAccountDetails() {
    let customerId = parseInt(document.getElementById('customerId').value); //customer ID
    let customerAccounts = [
        {
            //samples

            accountId: 11,
            accountNumber: 567786554,
            customerId: 1,
            accountType: "Savings",
            accountStatus: "Inactive",
            accountBalance: 5700.00
        },
        {
            accountId: 12,
            accountNumber: 553456789,
            customerId: 2,
            accountType: "fixed",
            accountStatus: "active",
            accountBalance: 500.00
        },
        {
            accountId: 13,
            accountNumber: 898765785,
            customerId: 1,
            accountType: "fixed",
            accountStatus: "active",
            accountBalance: 50000.00
        },
        {
            accountId: 23,
            accountNumber: 698765785,
            customerId: 1,
            accountType: "fixed",
            accountStatus: "active",
            accountBalance: 50000.00
        },
        {
            accountId: 14,
            accountNumber: 1208765785,
            customerId: 1,
            accountType: "savings",
            accountStatus: "active",
            accountBalance: 40000.00
        }, ];
//filter by customer id and active
    let activeAccounts = customerAccounts.filter(account => account.customerId === customerId && account.accountStatus === 'active');
  displayAccountDetails(activeAccounts);
}
//display function
function displayAccountDetails(activeAccounts) {
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const paginatedAccounts = activeAccounts.slice(startIndex, endIndex);
    let accountDetailsContainer = document.getElementById('accountDetailsContainer');
    accountDetailsContainer.innerHTML = '';
    if (paginatedAccounts.length > 0) {
        paginatedAccounts.forEach(account => {
            let accountCard = document.createElement('div');
            accountCard.className = 'col-lg-6 account-box';
            accountCard.innerHTML = `
            
                <h3 class="account-details-title">Account Details</h3>
                <p><strong>Account ID:</strong> ${account.accountId}</p>
                <p><strong>Account Number:</strong> ${account.accountNumber}</p>
                <p><strong>Customer ID:</strong> ${account.customerId}</p>
                <p><strong>Account Type:</strong> ${account.accountType}</p>
                <p><strong>Account Status:</strong> ${account.accountStatus}</p>
                <p><strong>Account Balance:</strong> ${account.accountBalance}</p>
            `;
            accountDetailsContainer.appendChild(accountCard);
        });
        renderPagination(activeAccounts.length);
    } else {
        alert('customer id has inactive accounts');
    }
}
function renderPagination(totalItems) {
    const totalPages = Math.ceil(totalItems / itemsPerPage);
    const paginationContainer = document.getElementById('pagination');
    paginationContainer.innerHTML = '';

    if (totalPages > 1) {
        for (let i = 1; i <= totalPages; i++) {
            const liClass = (i === currentPage) ? 'page-item active' : 'page-item';
            const paginationHtml = `
                <li class="${liClass}">
                    <button class="page-link" onclick="changePage(${i})">${i}</button>
                </li>
            `;
            paginationContainer.innerHTML += paginationHtml; } }}
function changePage(page) {
    currentPage = page;
    fetchAccountDetails();
}