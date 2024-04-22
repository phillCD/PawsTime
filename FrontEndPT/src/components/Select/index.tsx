interface SelectComponentProps {
  label: string;
}

const SelectComponent = ({ label }: SelectComponentProps) => {
  return (
    <div>
      <p className="font-medium	">{label}</p>
      <div>
        <select className="w-full border border-slate-600 rounded-md placeholder:text-xs p-2" />
      </div>
    </div>
  );
};

export default SelectComponent;
