export interface IQuery {
  pageNum: number;
  pageSize: number;
  username: string;
  email: string;
  address: string;
}
export class User {
  id?: number;
  username: string;
  nickname: string;
  email: string;
  phone: string;
  address: string;
  avatarUrl: string;
  avatarHash: string;
  constructor() {
    this.username = "";
    this.nickname = "";
    this.email = "";
    this.phone = "";
    this.address = "";
    this.avatarUrl = "";
    this.avatarHash = "";
  }
}
