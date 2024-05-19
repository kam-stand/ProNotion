import "././pages_styling_theme/about.css";

export default function About() {
  return (
    <div className="Parent">
      <div className="card">
        <div>
          <h1>About</h1>
        </div>
        <div>
          <h2>Subheading</h2>
        </div>
        <div>
          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero odio
            nesciunt consequatur blanditiis rem assumenda tempora quasi nulla?
            Natus eum vel deleniti quas neque itaque, delectus quis culpa
            provident dolorem!
          </p>
        </div>
      </div>
      <div className="hero_image">
        <img
          src="https://images.pexels.com/photos/4065891/pexels-photo-4065891.jpeg?cs=srgb&dl=pexels-cottonbro-4065891.jpg&fm=jpg"
          alt="logo"
          width="700px"
          border-radius="20%"
        />
      </div>
    </div>
  );
}
