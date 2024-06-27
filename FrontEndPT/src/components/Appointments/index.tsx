interface IAppointmentsProps {
  onClick: () => void;
  hour: string;
  name: string;
  procedure: string;
  status: string;
}

export default function Appointments({
  onClick,
  hour,
  name,
  procedure,
  status,
}: IAppointmentsProps) {
  return (
    <div
      className="flex flex-row w-full p-2 px-6 bg-slate-100 rounded-md items-center hover:opacity-40 cursor-pointer"
      onClick={onClick}
    >
      <div className="bg-green-500 px-2 rounded-md text-white">
        <p>{hour}</p>
      </div>
      <div className="flex flex-row flex-1 justify-around">
        <p>{name}</p>
        <p>{procedure}</p>
        <p>{status}</p>
      </div>
    </div>
  );
}
