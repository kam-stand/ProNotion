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

      <div className="welcome-body">
        <div className="info">
          <div>
            <h2>Why choose us?</h2>
            <div className="sub-info">
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
      <div className="welcome-body">
        <div className="info">
          <div>
            <h2>How to get started?</h2>
            <div className="sub-info">
              <ol className="list">
                <li>Sign up</li>
                <li>Sign in</li>
                <li>Start using</li>
              </ol>
            </div>
          </div>
        </div>
      </div>

      <div className="welcome-footer">
        <Footer />
      </div>
    </div>
  );
}
