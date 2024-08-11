import Footer from "../page_layouts/footer";
import Header from "../page_layouts/header";
import "../styles/welcome_page.css";
import { TbSettingsAutomation } from "react-icons/tb";
import { MdManageAccounts } from "react-icons/md";
import { SiAmazonsimpleemailservice } from "react-icons/si";
import { PiMoneyWavyBold } from "react-icons/pi";
import { GrSecure } from "react-icons/gr";
import { PiPersonSimpleRunBold } from "react-icons/pi";

export default function WelcomePage() {
  return (
    <div className="welcome-parent">
      <div className="welcome-header">
        <Header />
      </div>
      <div className="welcome-body">
        <div className="info">
          <div>
            <h2>What we offer!</h2>
            <div className="sub-info">
              <ol className="list">
                <li>
                  Project Management
                  <MdManageAccounts size={35} className="icon" />
                </li>
                <li>
                  Automation and templates
                  <TbSettingsAutomation size={35} className="icon" />
                </li>
                <li>
                  Email and task agendas
                  <SiAmazonsimpleemailservice size={35} className="icon" />
                </li>
              </ol>
            </div>
          </div>
        </div>
      </div>
      <div className="infographic">
        <img
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQd5j-egRUfvCx1xK_LPVmf4o5XgNZh4jCxVw&usqp=CAU"
          alt="project-management"
          sizes="30"
        />
        <div className="info-2">
          <h2>Project Management</h2>
          <p>
            Manage your projects with ease. Create, assign, and track tasks
            efficiently.
          </p>
        </div>
      </div>

      <div className="welcome-body">
        <div className="info">
          <div>
            <h2>Why choose us?</h2>
            <div className="sub-info">
              <a href="/price" className="price">
                Pricing
              </a>
              <ol className="list">
                <li>
                  Affordable
                  <PiMoneyWavyBold size={35} className="icon" />
                </li>
                <li>
                  Easy to use
                  <PiPersonSimpleRunBold size={35} className="icon" />
                </li>
                <li>
                  Secure
                  <GrSecure size={35} className="icon" />
                </li>
              </ol>
            </div>
          </div>
        </div>
      </div>
      <div className="infographic">
        <img
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ24i_9FEeJJoxFjG5wyFR_ntQHY4gGjB_7QA&usqp=CAU"
          alt="dev-management"
          sizes="30"
        />
        <div className="info-2">
          <h2>Development Management</h2>
          <p>
            Manage your development projects with ease. Create, assign, and
            track tasks efficiently.
          </p>
        </div>
      </div>

      <div className="welcome-footer">
        <Footer />
      </div>
    </div>
  );
}
