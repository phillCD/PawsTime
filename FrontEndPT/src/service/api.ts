const urlBase = 'http://localhost:8080/'

export const fetchGet = async (url: string) => {
    const res = await fetch(`${urlBase}${url}`);
    const data = await res.json();

    return data
}

export const fetchPost = async (url: string, body: any) => {
    console.log(`body`, body);
    
    const res = await fetch(`${urlBase}${url}`, {
        method: 'POST',
        body: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json",
          },
    });
    const data = await res.json();

    return data
}