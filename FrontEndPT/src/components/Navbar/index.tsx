import { useState }from "react";
import { Outlet } from "react-router-dom";
import './styles.css';
import NavButton from "../NavButton";
import ScheduleIcon from "../../assets/notebook.svg";
import PawIcon from "../../assets/paw.svg";
import UserIcon from "../../assets/user.svg";

export default function NavBar() {
    const [menuOpen, setMenuOpen] = useState(false);

    return(
    <>
        <header className="navContainer">
            <nav className="pr-6">
                <div className="menu" onClick={() => setMenuOpen(!menuOpen)}>
                    <span>spam</span>
                    <span></span>
                    <span></span>
                </div>
                <ul className={menuOpen ? 'open' : 'flex-1 items-center justify-center'}>
                    <li>
                        <NavButton 
                            link="/schedule"
                            text="Agenda" 
                            icon={<img src={ScheduleIcon} alt="Icone de Agenda" />} 
                        />
                    </li>
                    <li>
                        <NavButton 
                            link="/patients"
                            text="Pacientes" 
                            icon={<img src={PawIcon} alt="Icone de Pata de Animal" />} 
                        />
                    </li>
                </ul>
                <div className="button p-2 rounded-md">
                <NavButton
                    link="/patients"
                    text="Perfil" 
                    icon={<img src={UserIcon} alt="Icone de Pata de Animal" />} 
                />
                </div>
            </nav>
        </header>
        <main>
            <Outlet/>
        </main>
    </>
    )
}