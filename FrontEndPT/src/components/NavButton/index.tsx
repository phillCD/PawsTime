import { ReactNode } from "react";
import { NavLink } from "react-router-dom";

interface NavButtonProps {
    link: string;
    text: string;
    icon: ReactNode;
}

export default function NavButton(props: NavButtonProps) {
    return (
        <button>
            <NavLink className="text-white flex flex-row items-center" to={props.link}>
                <div className="pr-2">{props.icon}</div>
                {props.text}
            </NavLink>
        </button>
    )
}