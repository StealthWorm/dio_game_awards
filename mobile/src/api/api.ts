//localhost:8080

const baseURL = "http://10.0.0.98:8080/";

export async function clientGames() {
  const response = await fetch(`${baseURL}games`);
  const json = await response.json();

  console.log(json);
  return json;
}

export async function clientSendingVotes(id: number) {
  const requestOption = { method: "PATCH" };
  fetch(`${baseURL}games/${id}/vote`, requestOption)
    .then((response) => response.json())
    .then((data) => data)
    .catch((err) => console.log(err));
}

export async function clientGetWinner() {
  const response = await fetch(`${baseURL}games`);
  const json = await response.json();
  return json[0];
}
