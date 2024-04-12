
interface SimpleButtonProps {
    icon: string;
}

const SimpleButton = ({icon}: SimpleButtonProps) => {

    return(
        <button className="p-2 bg-green-500 rounded-md">
            <img src={icon} alt="Icone de Dono" />
        </button>

    )
}

export default SimpleButton;