interface InputComponentProps {
    label: string
}

const InputComponent = ({ label }: InputComponentProps) => {

    return (
        <div>
            <p className="font-medium	">{label}</p>
            <div>
                <input className="border border-slate-600 rounded-md placeholder:text-xs p-2" />
            </div>
        </div>
    )
}

export default InputComponent;  