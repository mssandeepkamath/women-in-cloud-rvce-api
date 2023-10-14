# Women In Cloud RVCE API (UNOFFICIAL)

<a href="https://render.com"><img alt="Production" src="https://img.shields.io/badge/production-up-lgreen.svg"/></a>
[![Maintainability](https://api.codeclimate.com/v1/badges/a5688e693a48ff0953ca/maintainability)](https://codeclimate.com/github/mssandeepkamath/women-in-cloud-rvce-api/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/a5688e693a48ff0953ca/test_coverage)](https://codeclimate.com/github/mssandeepkamath/women-in-cloud-rvce-api/test_coverage)

Unofficial API for Women In Cloud RVCE Center of Excellence Management.

![Architecture](https://user-images.githubusercontent.com/90695071/229217757-4a582538-3619-4a4a-9970-b0537a488e50.png)


## Table of Contents

- [About](#about)
- [Android App](#android-app)
- [API Documentation](#api-documentation)
- [Environment Variables](#environment-variables)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## About

Women In Cloud RVCE API provides an unofficial backend service for the Women In Cloud RVCE Android App. It offers various endpoints to manage projects, internships, events, student details, staff registration, and more.

## Android App

The Android app is available on the Play Store. Explore it [here](https://play.google.com/store/apps/details?id=com.sandeep.womenincloudrvce).

Repository: [women-in-cloud-rvce-android](https://github.com/mssandeepkamath/women-in-cloud-rvce-android)

## API Documentation

### Base URL

The base URL for API endpoints is `https://...`.

### Endpoints

- `/project-applied-students/{project_id}/`: Get students who applied for a project.
- `/internship-applied-students/{internship_id}/`: Get students who applied for an internship.
- `/event-applied-students/{event_id}/`: Get students who applied for an event.
- `/add-project`: Add a new project.
- `/add-internship`: Add a new internship.
- `/add-event`: Add a new event.
- `/hire-project`: Hire a student for a project.
- `/hire-internship`: Hire a student for an internship.
- `/upload-project-document/{project_id}`: Upload project documents.
- `/upload-internship-document/{internship_id}`: Upload internship documents.
- `/upload-event-document/{event_id}`: Upload event documents.
- `/student`: Get student details by USN.
- `/funds`: Get funds information.
- `/add-fund`: Add a new fund.
- `/students`: Get registered students.
- `/all-project-applied-students`: Get all students who applied for projects.
- `/all-internship-applied-students`: Get all students who applied for internships.
- `/all-event-applied-students`: Get all students who applied for events.
- `/register-staff`: Register a staff member.
- `/get-staff`: Get a list of staff members.
- `/studentsCSV`: Get student details in CSV format.

Refer to the [Java class diagram](https://user-images.githubusercontent.com/90695071/232433709-a390d603-3a38-401e-9adb-9799d075d41c.png) and [Spring model dependency diagram](https://user-images.githubusercontent.com/90695071/232434107-1a720fa8-e055-4b83-99f1-8bfc1b52f798.png) for an overview of the application's structure.

## Environment Variables

Ensure to set the following environment variables:

- `sql_user_name`
- `sql_password`
- `google_password`
- `google_user_name`

## Contributing

Contributions are welcome! To contribute:

1. Fork this repository.
2. Clone the forked repository locally.
3. Create a new branch for your feature/fix.
4. Make your changes and commit them.
5. Push the changes to your fork.
6. Create a pull request in the original repository.

## License

This project is licensed under the [MIT License](Licence).

## Contact

For questions or feedback, feel free to [contact us](mailto:msandeepcip@gmail.com).

---

**Disclaimer:** This project is not affiliated with any official Women In Cloud RVCE platforms. It's developed independently for educational and community purposes.
