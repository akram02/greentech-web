export interface IProduct {
  id?: number;
  userId?: number;
  name?: string;
  location?: string;
  category?: string;
}

export class Product implements IProduct {
  constructor(public id?: number, public userId?: number, public name?: string, public location?: string, public category?: string) {}
}
