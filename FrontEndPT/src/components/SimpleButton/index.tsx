
interface SimpleButtonProps {
    icon: string;
}

const SimpleButton = ({icon}: SimpleButtonProps) => {

    return(
        <div className="flex flex-1 items-center justify-center">
            <button className="bg-blue-500 flex-1 h-full items-center justify-center">
                <img src={icon} alt="Icone de Dono" />
            </button>
        </div>
    )
}

export default SimpleButton;