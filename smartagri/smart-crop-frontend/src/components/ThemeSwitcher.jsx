export default function ThemeSwitcher() {

  const changeTheme = (e) => {
    document.documentElement.setAttribute("data-theme", e.target.value);
    localStorage.setItem("theme", e.target.value);
  };

  return (
    <select className="theme-select" onChange={changeTheme}>
      <option value="">Themes</option>
      <option value="green">Green</option>
      <option value="sunset">Sunset</option>
      <option value="purple">Purple</option>
      <option value="earth">Earth</option>
      <option value="ai-blue">AI Blue</option>
      <option value="nature">Nature</option>
      <option value="night">Night</option>
      <option value="neon">Neon</option>
      <option value="gold">Gold</option>
      <option value="light">Light</option>
    </select>
  );
}
