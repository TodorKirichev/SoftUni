function attachEvents() {

  const URL = 'http://localhost:3030/jsonstore/collections/students';

  const tbody = document.querySelector('tbody');
  const submitButton = document.querySelector('button#submit');

  fetch(URL)
  .then(res => res.json())
  .then(students => {
    Object.values(students).forEach(student => {

      const tr = createTr(student);

      tbody.appendChild(tr);
    })
  })

  submitButton.addEventListener('click', createStudent);

  function createStudent() {
    const [firstName, lastName, facultyNumber, grade] = document.querySelectorAll('input');

    const isValid = firstName.value !== '' && lastName.value !== '' && facultyNumber.value !== '' && grade.value !== '';

    if (isValid) {
      const student = {
        firstName: firstName.value,
        lastName: lastName.value,
        facultyNumber: facultyNumber.value,
        grade:grade.value
      }

      fetch(URL, {
        method: 'POST',
        body: JSON.stringify(student),
        headers: {
          'Content-Type': 'application/jason'
        }
      })
      .then(res => res.json())
      .then(s => {

      const tr = createTr(s);

      tbody.appendChild(tr);

      firstName.value = '';
      lastName.value = '';
      facultyNumber.value = '';
      grade.value = '';
      })
    }
    
  }

  function createTr(student) {
      const tr = document.createElement('tr');

      const tdFirstName = document.createElement('td');
      tdFirstName.textContent = student.firstName;

      const tdLastName = document.createElement('td');
      tdLastName.textContent = student.lastName;

      const tdFacultyNumber = document.createElement('td');
      tdFacultyNumber.textContent = student.facultyNumber;
      
      const tdGrade = document.createElement('td');
      tdGrade.textContent = student.grade;

      tr.appendChild(tdFirstName);
      tr.appendChild(tdLastName);
      tr.appendChild(tdFacultyNumber);
      tr.appendChild(tdGrade);

      return tr;
  }
  
}
attachEvents();