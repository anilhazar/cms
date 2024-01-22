const TABLE_ELEMENT_ID = "content-table"
const TABLE_TITLE_ELEMENT_ID = "content-table-title"
const DATA_FORM_ELEMENT_ID = "data-form"

const COMMON_TABLE_DEFINITION = [
    {key:"actions", label: "Actions", render: renderActionsCell}
]

const TABLE_DEFINITION = {
    employees: [
        {key:"id", label: "ID"},
        {key:"age", label: "Age"},
        {key:"birthDate", label: "Birth Date"},
        {key:"firstName", label: "First Name"},
        {key:"lastName", label: "Last Name"},
        ...COMMON_TABLE_DEFINITION
    ],
    branch: [
        {key:"id", label: "ID"},
        {key:"name", label: "Name"},
        ...COMMON_TABLE_DEFINITION
    ],
    leave: [
        {key:"id", label: "ID"},
        {key:"reason", label: "Reason"},
        {key:"startDate", label: "Start Date"},
        {key:"endDate", label: "End Date"},
        ...COMMON_TABLE_DEFINITION
    ],
    project : [
        {key:"id", label: "ID"},
        {key:"name", label: "Name"},
        ...COMMON_TABLE_DEFINITION
    ]
}


const TABLE_TITLE = {
    employees: "Employees",
    branch: "Branches",
    leave: "Leaves",
    project: "Projects"
}

const COMMON_FORM_DEFINITION = [
    {key: "id", label: "ID", type: "number", placeholder: "ID", hidden: true},
]

const FORM_DEFINITION = {
    employees: [
        {key: "age", label: "Age", type: "text", placeholder: "Age"},
        {key: "birthDate", label: "Birth Date", type: "text", placeholder: "Birth Date (XXXX-XX-XX)"},
        {key: "firstName", label: "First Name", type: "text", placeholder: "First Name"},
        {key: "lastName", label: "Last Name", type: "text", placeholder: "Last Name"},
        ...COMMON_FORM_DEFINITION
    ],
    branch: [
        {key: "name", label: "Name", type: "text", placeholder: "Name"},
        ...COMMON_FORM_DEFINITION        
    ],
    leave: [
        {key: "reason", label: "Reason", type: "text", placeholder: "Reason"},
        {key: "startDate", label: "Start Date", type: "text", placeholder: "Start Date"},
        {key: "endDate", label: "End Date", type: "text", placeholder: "End Date"},
        ...COMMON_FORM_DEFINITION        
    ],
    project: [
        {key: "name", label: "Name", type: "text", placeholder: "Name"},
        ...COMMON_FORM_DEFINITION        
    ]

}

const BASE_URL = "http://localhost:8080/api/v1"

const DATA_ENDPOINTS = {
    employees: `${BASE_URL}/employees`,
    branch: `${BASE_URL}/branches`,
    leave: `${BASE_URL}/leaves`,
    project: `${BASE_URL}/projects`
}

const modal = new bootstrap.Modal("#data-form-modal")

let currentDataType = "employees"
let currentEmployeeId = null

function onLoad() {
    renderTable(currentDataType)
}

function onDataTypeChange(dataType) {
    currentDataType = dataType
    renderTable(currentDataType)
}

function renderTableTitle(dataType) {
    const tableTitleElement = document.getElementById(TABLE_TITLE_ELEMENT_ID)
    tableTitleElement.innerHTML = TABLE_TITLE[dataType]
}

/**
 * @param {HTMLTableCellElement} cell
 * @param {Object} data
*/
function renderActionsCell(cell, data) {
    const editButton = document.createElement("button")
    const deleteButton = document.createElement("button")

    editButton.innerHTML = "Edit"
    deleteButton.innerHTML = "Delete"

    editButton.classList.add("btn")
    editButton.classList.add("btn-primary")
    editButton.classList.add("mr-2")
    deleteButton.classList.add("btn")
    deleteButton.classList.add("btn-danger")

    editButton.onclick = () => {
        console.log("Edit clicked")
        renderForm(currentDataType)
        setFormData(data)
        modal.show()   
    }

    deleteButton.onclick = () => {
        console.log("Delete clicked")
        deleteData(currentDataType, data.id).then(() => {
            renderTable(currentDataType)
        })
    }

    if(currentDataType === "employees") {
        const leaveButton = document.createElement("button")
        leaveButton.innerHTML = "Leave"
        leaveButton.classList.add("btn")
        leaveButton.classList.add("btn-warning")
        leaveButton.classList.add("mr-2")
        leaveButton.onclick = () => {
            console.log("Leave clicked")
            currentEmployeeId = data.id
            onDataTypeChange("leave")
        }
        cell.appendChild(leaveButton)
    }

    const divElement = document.createElement("div")
    divElement.appendChild(editButton)
    divElement.appendChild(deleteButton)

    cell.appendChild(divElement)
}

function renderTable(dataType) {
    const tableElement = document.getElementById(TABLE_ELEMENT_ID)
    
    renderTableTitle(dataType)
    renderTableHead(tableElement, dataType)
    renderTableBody(tableElement, dataType)
}

/**
 * @param {HTMLElement} table
 * @param {string} dataType
 */
function renderTableHead(table, dataType) {
    const tableHead = table.getElementsByTagName("thead")[0]
    tableHead.innerHTML = ""

    const row = tableHead.insertRow()

    const tableDefinition = TABLE_DEFINITION[dataType]

    tableDefinition.forEach((item) => {
        const cell = row.insertCell()
        const text = document.createTextNode(item.label)
        cell.scope = "col"
        cell.appendChild(text)
    })
}

/**
 * @param {HTMLElement} table
 * @param {string} dataType
 */
function renderTableBody(table, dataType) {
    const tableBody = table.getElementsByTagName("tbody")[0]
    tableBody.innerHTML = ""
    const tableDefinition = TABLE_DEFINITION[dataType]

    const data = getData(dataType).then(data => {
        renderTableBodyRows(tableBody, tableDefinition, data)
    })

    
}

/**
 * @param {HTMLElement} tableBody
 * @param {Array} tableDefinition
 * @param {Array} data
 */
function renderTableBodyRows(tableBody, tableDefinition, data) {
    if (!data) return
    data.forEach((item) => {
        const row = tableBody.insertRow()

        tableDefinition.forEach((definition) => {
            let cell = row.insertCell()
            if(definition.render) definition.render(cell, item)
            else {
                const text = document.createTextNode(item[definition.key])
                cell.appendChild(text)
            }
        })
    })
}

function openCreateForm() {
    const form = document.forms[DATA_FORM_ELEMENT_ID]
    form.reset()
    renderForm(currentDataType)
    modal.show()
}

function renderForm(dataType) {
    const form = document.forms[DATA_FORM_ELEMENT_ID]
    const formDefinition = FORM_DEFINITION[dataType]
    const formBody = form.getElementsByClassName("modal-body")[0]
    formBody.innerHTML = ""

    formDefinition.forEach((item) => {

        const divElement = document.createElement("div")
        divElement.classList.add("mb-3")
        divElement.classList.add("form-group")
        divElement.hidden = item.hidden

        const labelElement = document.createElement("label")
        labelElement.classList.add("form-label")
        labelElement.innerHTML = item.label

        const inputElement = document.createElement("input")
        inputElement.classList.add("form-control")
        inputElement.type = item.type
        inputElement.name = item.key
        inputElement.placeholder = item.placeholder
        inputElement.required = item.required

        divElement.appendChild(labelElement)
        divElement.appendChild(inputElement)

        formBody.appendChild(divElement)
    })
}

function setFormData(data) {
    const form = document.forms[DATA_FORM_ELEMENT_ID]
    const formDefinition = FORM_DEFINITION[currentDataType]
    formDefinition.forEach((item) => {
        form[item.key].value = data[item.key]
    })
}

function saveForm() {
    saveData(currentDataType).then(() => {
        renderTable(currentDataType)
        modal.hide()
    })
}


/**
 * @param {string} dataType
 */
function getData(dataType) {
    let endpoint = DATA_ENDPOINTS[dataType]

    if(dataType === "leave") endpoint = `${endpoint}/${currentEmployeeId}`

    return fetch(endpoint)
        .then(response => response.json())
        .then(data => data)
        .catch(error => console.log(error))
}


function deleteData(dataType, id) {
    const endpoint = `${DATA_ENDPOINTS[dataType]}/${id}`
    return fetch(endpoint, {
        method: "DELETE"
    })
        .then(response => response.json())
        .then(data => data)
        .catch(error => console.log(error))
}

function saveData(dataType) {
    const form = document.forms[DATA_FORM_ELEMENT_ID]
    let endpoint = DATA_ENDPOINTS[dataType]
    const data = Object.fromEntries(new FormData(form))
    const method = data.id ? "PUT" : "POST"

    
    if(data.id) endpoint = `${endpoint}/${data.id}`
    else if(dataType === "leave") endpoint = `${endpoint}/${currentEmployeeId}`

    return fetch(endpoint, {
        method: method,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
        .catch(error => console.log(error))
}