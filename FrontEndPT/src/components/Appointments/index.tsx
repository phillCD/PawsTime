
export default function Appointments() {
    return (
        <div className="flex flex-row w-full p-2 px-6 bg-slate-100 rounded-md items-center hover:opacity-40 cursor-pointer">
            <div className="bg-green-500 px-2 rounded-md text-white">
                <p>9:00</p>
            </div>
            <div className="flex flex-row flex-1 justify-around">
            <p>Nome Animal</p>
            <p>Procedimento</p>
            <p>Status</p>
            </div>
        </div>
    )
}