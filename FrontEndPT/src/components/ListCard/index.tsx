interface ListCardProps {
  id: string;
  petName: string;
  breed: string;
  ownerName: string;
}

export default function ListCard({
  id,
  breed,
  ownerName,
  petName,
}: ListCardProps) {
  return (
    <div className="flex flex-row w-full p-2 px-10 bg-slate-100 rounded-md items-center hover:opacity-40 cursor-pointer">
      <div className="flex flex-row flex-1 justify-between">
        <p>{id}</p>
        <p>{breed}</p>
        <p>{petName}</p>
        <p>{ownerName}</p>
      </div>
    </div>
  );
}
