export default class MovieBean{
  name:string
  image:Resource

  constructor(name:string,image:Resource) {
    this.image=image
    this.name=name
  }
}