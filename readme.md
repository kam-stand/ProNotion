<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->

<a id="readme-top"></a>

<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![Unlicense License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/ProNotion">
    <img src="./images/New_to_Notion_-_Chapter_Thumbnail.png" alt="Logo" width="300" height="300">
  </a>

  <h3 align="center">An all in one productivity Platform</h3>
<p align="center">
    The all-in-one productivity platform for modern teams and individuals!
    <br />
    <a href="https://github.com/kam-stand/ProNotion"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/kam-stand/ProNotion">View Demo</a>
    &middot;
    <a href="https://github.com/kam-stand/ProNotion/issues/new?labels=bug&template=bug-report.md">Report Bug</a>
    &middot;
    <a href="https://github.com/kam-stand/ProNotion/issues/new?labels=enhancement&template=feature-request.md">Request Feature</a>
</p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

[![Product Name Screen Shot][product-screenshot]](https://example.com)
ProNotion was built to make productivity seamless, collaborative, and accessible for everyone. Unlike other platforms that can feel overwhelming or rigid, ProNotion is designed to be intuitive, flexible, and powerful—so you can focus on what matters most: getting things done.

Here's why you'll love using ProNotion:

- 🚀 **All-in-one Workspace:** Manage notes, tasks, files, and more in a single, unified platform.
- 🧩 **Easy to Use:** Clean UI and simple onboarding mean you can get started in minutes, not hours.
- 🔒 **Secure & Scalable:** Built with modern technologies like React, Spring Boot, AWS, and Google Cloud for reliability and security.
- 🌎 **Accessible Anywhere:** Cloud-based and responsive, so your workflow goes wherever you do.
- ⚡ **Customizable:** Adapt ProNotion to your needs—whether you’re a solo user or a growing team.
- 🤝 **Open Source:** Contribute, customize, and make it your own. We welcome your ideas and improvements!

ProNotion is more than just a productivity tool—it's your digital command center.  
Jump in, explore, and see how much more you can accomplish!

If you have suggestions or want to contribute, just fork the repo or open an issue.  
Thanks to everyone who’s helping make ProNotion better every day!

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

This project leverages a modern full-stack technology suite:

### Built With

This project leverages a modern full-stack technology suite:

[![React][React.js]][React-url]
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![AWS](https://img.shields.io/badge/AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white)](https://aws.amazon.com/)
[![Google Cloud](https://img.shields.io/badge/Google_Cloud-4285F4?style=for-the-badge&logo=google-cloud&logoColor=white)](https://cloud.google.com/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Amazon S3](https://img.shields.io/badge/Amazon_S3-569A31?style=for-the-badge&logo=amazons3&logoColor=white)](https://aws.amazon.com/s3/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->

## Getting Started

Follow these instructions to set up the project locally.

### Prerequisites

- [Node.js & npm](https://nodejs.org/) (for the frontend)
- [Maven](https://maven.apache.org/) (for the backend)
- [Java 17+](https://adoptopenjdk.net/) (for the backend)
- [Git](https://git-scm.com/)
- AWS account with S3 access
- Google Cloud account for OAuth credentials

### Installation

1. **Clone the repository**

   ```sh
   git clone https://github.com/kam-stand/ProNotion.git
   cd ProNotion
   ```

2. **Set up Google OAuth credentials**

   - Go to [Google Cloud Console](https://console.cloud.google.com/apis/credentials)
   - Create OAuth 2.0 credentials and download the `credentials.json` file.
   - Place the `credentials.json` file in the appropriate backend directory (see `application.properties` for the expected path).

3. **Set up Amazon S3 bucket**

   - Create an S3 bucket in your AWS account.
   - Note the bucket name, region, and your AWS access/secret keys.
   - Update the S3-related properties in `server/my-springboot-project/src/main/resources/application.properties` with your bucket and credentials.

4. **Configure application properties**

   - Open `server/my-springboot-project/src/main/resources/application.properties`.
   - Set your database connection, OAuth, and AWS S3 credentials as required.

# Database Configuration

> spring.datasource.url=jdbc:mysql://db:3306/YOUR_DATABASE_NAME
> 
> spring.datasource.username=YOUR_DATABASE_USERNAME
> 
> spring.datasource.password=YOUR_DATABASE_PASSWORD
> 
> spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
> 
> spring.jpa.hibernate.ddl-auto=update
> 
> spring.jpa.show-sql=true

# Google OAuth2 Configuration

> spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
> 
> spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
> 
> spring.security.oauth2.client.registration.google.scope=email,profile

# AWS S3 Configuration

> aws.s3.bucket.name=YOUR_S3_BUCKET_NAME
> 
> aws.access.key=YOUR_AWS_ACCESS_KEY
> 
> aws.secret.key=YOUR_AWS_SECRET_KEY
> 
> aws.s3.region=YOUR_AWS_REGION

# Application Configuration

> server.port=8080

5. **Install frontend dependencies**

   ```sh
   cd client/pronotion
   npm install
   ```

6. **Install backend dependencies and build**

   ```sh
   cd ../../server/my-springboot-project
   mvn clean install
   ```

7. **Run the backend**

   ```sh
   mvn spring-boot:run
   ```

8. **Run the frontend**
   ```sh
   cd ../../client/pronotion
   npm start
   ```

### Using Docker

ProNotion comes with Docker configuration for easy deployment and consistent environments across different systems.

#### Prerequisites for Docker Setup

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

#### Option 1: Run with Docker Compose (Recommended)

1. **Configure application properties**

   - Create or update `server/my-springboot-project/src/main/resources/application.properties` with your credentials:

   ```properties
   # Database Configuration
   spring.datasource.url=jdbc:mysql://db:3306/YOUR_DATABASE_NAME
   spring.datasource.username=YOUR_DATABASE_USERNAME
   spring.datasource.password=YOUR_DATABASE_PASSWORD
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

   # Google OAuth2 Configuration
   spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
   spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
   spring.security.oauth2.client.registration.google.scope=email,profile

   # AWS S3 Configuration
   aws.s3.bucket.name=YOUR_S3_BUCKET_NAME
   aws.access.key=YOUR_AWS_ACCESS_KEY
   aws.secret.key=YOUR_AWS_SECRET_KEY
   aws.s3.region=YOUR_AWS_REGION

   # Application Configuration
   server.port=8080
   ```

---

**Note:**

- Make sure your Java version matches the one specified in the backend's `pom.xml`.
- Check `application.properties` for any other required configuration (e.g., database URL, email settings).

<p align="right">(<a href="#readme-top">back to top</a>)</p>
<!-- USAGE EXAMPLES -->

## Usage

See ProNotion in action! Below are some examples of how you can use the platform to boost your productivity.

### 📹 Demo Video

[![Watch the demo](https://img.shields.io/badge/Watch%20Demo-YouTube-red?style=for-the-badge&logo=youtube)](https://www.youtube.com/watch?v=YOUR_VIDEO_ID)

### ✨ Features Showcase

![ProNotion Dashboard GIF](./images/demo-dashboard.gif)

- **Organize notes, tasks, and files** in one place
- **Collaborate in real-time** with your team
- **Upload and manage files** with AWS S3 and Google Cloud integration
- **Search instantly** with Elastic Search (coming soon!)
- **Customize your workspace** to fit your workflow

_For more examples and advanced usage, please refer to the [Documentation](https://github.com/kam-stand/ProNotion/wiki)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>
<!-- ROADMAP -->

## Roadmap

- [x] Add Changelog 📝
- [ ] Email Integration 📧
- [ ] File Uploads to S3 & GCP ☁️📤
- [ ] Elastic Search Integration 🔍

See the [open issues](https://github.com/kam-stand/ProNotion/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make to **ProNotion** are **greatly appreciated**!

If you have a suggestion that would make ProNotion better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".  
Don't forget to give the project a ⭐ if you like it—thanks for helping make ProNotion awesome!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Top contributors

<a href="https://github.com/kam-stand/ProNotion/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=kam-stand/ProNotion" alt="contrib.rocks image" />
</a>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->

## License

Distributed under the Unlicense License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->

## Contact

[![Email](https://img.shields.io/badge/Email-kh84590@gmail.com-red?style=for-the-badge&logo=gmail&logoColor=white)](mailto:kh84590@gmail.com)
[![GitHub](https://img.shields.io/badge/GitHub-kam--stand-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/kam-stand)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-kam--hassan-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/kam-hassan)

Project Link: [https://github.com/kam-stand/ProNotion](https://github.com/kam-stand/ProNotion)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->

## Acknowledgments

Use this space to list resources you find helpful and would like to give credit to. Here are some that were especially helpful for ProNotion:

- [Choose an Open Source License](https://choosealicense.com)
- [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
- [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
- [Malven's Grid Cheatsheet](https://grid.malven.co/)
- [Img Shields](https://shields.io)
- [GitHub Pages](https://pages.github.com)
- [Font Awesome](https://fontawesome.com)
- [React Icons](https://react-icons.github.io/react-icons/search)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Maven Documentation](https://maven.apache.org/guides/index.html)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [AWS Console Documentation](https://docs.aws.amazon.com/console/)
- [Google Cloud Documentation](https://cloud.google.com/docs)
- [Javax Mail (Jakarta Mail) API Docs](https://jakarta.ee/specifications/mail/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/kam-stand/ProNotion.svg?style=for-the-badge
[contributors-url]: https://github.com/kam-stand/ProNotion/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/kam-stand/ProNotion.svg?style=for-the-badge
[forks-url]: https://github.com/kam-stand/ProNotion/network/members
[stars-shield]: https://img.shields.io/github/stars/kam-stand/ProNotion.svg?style=for-the-badge
[stars-url]: https://github.com/kam-stand/ProNotion/stargazers
[issues-shield]: https://img.shields.io/github/issues/kam-stand/ProNotion.svg?style=for-the-badge
[issues-url]: https://github.com/kam-stand/ProNotion/issues
[license-shield]: https://img.shields.io/github/license/kam-stand/ProNotion.svg?style=for-the-badge
[license-url]: https://github.com/kam-stand/ProNotion/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/kam-hassan
[product-screenshot]: ./images/Gemini_Generated_Image_pt4dy1pt4dy1pt4d.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
