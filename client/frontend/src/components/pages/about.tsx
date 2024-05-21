import "././pages_styling_theme/about.css";
import logo from "../../assets/ProNotion Logo Design.png";
export default function About() {
  return (
    <div className="Layout">
      <div className="TopRow">
        <div className="Leftbox">
          <div>
            <h1>About</h1>
          </div>
          <div>
            <h2>Subheading</h2>
          </div>
          <div>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla
              convallis, felis nec ultrices ultricies, nunc purus fermentum
              justo, nec tempus odio eros nec nunc. Sed nec nunc sed mi
              malesuada tincidunt. Ut sed nunc nec purus fermentum commodo. Sed
              nec nunc sed mi malesuada tincidunt. Ut sed nunc nec purus
              fermentum commodo. Lorem ipsum dolor sit amet consectetur
              adipisicing elit. Cum, quia praesentium soluta at optio dolores
              unde numquam voluptatum aliquid maxime veniam commodi pariatur.
              Repudiandae sunt ratione illo aut laboriosam suscipit?
            </p>
            {/* <br></br>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse
              nobis quaerat saepe soluta eaque quas odio, deleniti aliquid
              expedita maiores magnam provident omnis ab facilis? Quisquam
              cupiditate fugiat animi laudantium! Lorem ipsum dolor sit amet,
              consectetur adipisicing elit. Beatae reiciendis sit itaque cum.
              Eligendi illo, voluptatem amet voluptatibus qui assumenda incidunt
              animi nulla similique! Quos aliquam quo porro voluptatum
              molestiae. Lorem ipsum dolor sit, amet consectetur adipisicing
              elit. Vitae velit officia esse ipsum in nulla ratione magni
              incidunt nam! Saepe voluptates officiis ipsam obcaecati. Fuga,
              sint assumenda? Praesentium, nam minus. Lorem ipsum dolor sit amet
              consectetur adipisicing elit. Quaerat, illum culpa obcaecati
              voluptatem ducimus accusantium aspernatur eius mollitia rerum
              consequuntur adipisci natus nobis porro doloremque maiores vero
              deleniti et consequatur!Lorem ipsum dolor sit amet consectetur
              adipisicing elit. Quaerat, illum culpa obcaecati voluptatem
              ducimus accusantium aspernatur eius mollitia rerum consequuntur
              adipisci natus nobis porro doloremque maiores vero deleniti et
              consequatur!
            </p> */}
          </div>
        </div>
        <div className="Rightbox">
          <div>
            <img
              src="https://images.pexels.com/photos/4065891/pexels-photo-4065891.jpeg?cs=srgb&dl=pexels-cottonbro-4065891.jpg&fm=jpg"
              alt="About"
              className="AboutImage"
            />
          </div>
        </div>
      </div>
      <img src={logo} alt="ProNotion Logo" className="ProNotionLogo" />
    </div>
  );
}
