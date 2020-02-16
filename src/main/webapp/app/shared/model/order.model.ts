export interface IOrder {
  id?: number;
  productId?: number;
  consumerId?: number;
  sellerId?: number;
  description?: string;
  status?: string;
}

export class Order implements IOrder {
  constructor(
    public id?: number,
    public productId?: number,
    public consumerId?: number,
    public sellerId?: number,
    public description?: string,
    public status?: string
  ) {}
}
