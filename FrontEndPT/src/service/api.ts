const urlBase = 'http://localhost:8080/'

export const fetchGet = async (url: string) => {
    const res = await fetch(`${urlBase}${url}`);
    const data = await res.json();

    return data
}

export const fetchPost = async (url: string, body: any) => {
    const res = await fetch(`${urlBase}${url}`, {
        method: 'POST',
        body: body,
        headers: {
            "Content-Type": "application/json",
          },
    });
    const data = await res.json();

    return data
}