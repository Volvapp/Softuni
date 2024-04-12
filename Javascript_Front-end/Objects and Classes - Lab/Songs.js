function songs(arr) {
  class Song {
    constructor(typeList, name, time) {
      this.typeList = typeList;
      this.name = name;
      this.time = time;
    }
  }
  let allSongs = [];
  const wantedTypeList = arr[arr.length - 1];
  for (let i = 1; i <= arr[0]; i++) {
    const [typeList, name, time] = arr[i].split("_");
    const currentSong = new Song(typeList, name, time);
    allSongs.push(currentSong);
  }

  for (const iterator of allSongs) {
    if (wantedTypeList === "all") {
      console.log(iterator.name);
    } else if (iterator.typeList === wantedTypeList) {
      console.log(iterator.name);
    }
  }
}

songs([2, "like_Replay_3:15", "ban_Photoshop_3:48", "all"]);
