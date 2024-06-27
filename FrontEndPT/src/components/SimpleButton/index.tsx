
interface SimpleButtonProps {
    icon?: string;
    label?: string;
    onClick: (e: React.MouseEvent<HTMLButtonElement>) => void;
}

const SimpleButton = ({icon, label, onClick}: SimpleButtonProps) => {

    return(
        <button className="p-2 bg-green-500 rounded-md hover:opacity-60" onClick={onClick}>
            {label && <p className="text-white">{label}</p>}
            {icon && <img src={icon} alt="Icone de Dono" />}
        </button>

    )
}

export default SimpleButton;